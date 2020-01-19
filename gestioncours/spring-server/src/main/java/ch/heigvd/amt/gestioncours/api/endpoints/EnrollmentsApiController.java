package ch.heigvd.amt.gestioncours.api.endpoints;

import ch.heigvd.amt.gestioncours.api.EnrollmentsApi;
import ch.heigvd.amt.gestioncours.api.exceptions.EnrollmentNotFoundException;
import ch.heigvd.amt.gestioncours.api.model.Enrollment;
import ch.heigvd.amt.gestioncours.api.model.EnrollmentList;
import ch.heigvd.amt.gestioncours.entities.EnrollmentEntity;
import ch.heigvd.amt.gestioncours.entities.SubjectEntity;
import ch.heigvd.amt.gestioncours.repositories.EnrollmentRepository;
import ch.heigvd.amt.gestioncours.repositories.SubjectRepository;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class EnrollmentsApiController implements EnrollmentsApi  {

    @Autowired
    EnrollmentRepository enrollmentsRepository;

    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    HttpServletRequest httpServletRequest;

    /**
     * create a new enrollment to post
     * @param enrollment the paramater to post
     * @return
     */
    public ResponseEntity<Enrollment> createEnrollment(@ApiParam(value = "" ,required=true )  @Valid @RequestBody Enrollment enrollment) {
        SubjectEntity subjectEntity = subjectRepository.findByid(enrollment.getSubjectId());

        System.out.println("name" + subjectEntity.getName());
        String mail = httpServletRequest.getAttribute("email").toString();

        EnrollmentEntity newEnrollementEntity = enrollmentsRepository.findByEmailAndAndSubject(mail, subjectEntity);

        if(newEnrollementEntity==null) {

            newEnrollementEntity = toEnrollmentEntity(enrollment);
            newEnrollementEntity.setEmail(mail);
            EnrollmentEntity saveEnrollmentEntity = enrollmentsRepository.save(newEnrollementEntity);//JPA ME RENVOIT L'OBJET PERSISTE
            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest().path("/{id}")
                    .buildAndExpand(saveEnrollmentEntity.getId()).toUri();
            return ResponseEntity.created(location).body(toEnrollment(saveEnrollmentEntity));
        }

        return  new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    /**
     * get an enrollment base on the id supplied
     * @param id of the enrollment
     * @return
     */
    public ResponseEntity<Enrollment> getEnrollmentById(@ApiParam(value = "ID of enrollment to fetch",required=true) @PathVariable("id") Integer id) {

        EnrollmentEntity enrollmentEntity = enrollmentsRepository.findById(id.longValue()).get();
            if(enrollmentEntity == null){
             throw new EnrollmentNotFoundException();
        }
        return ResponseEntity.ok(toEnrollment(enrollmentEntity));

    }

    /**
     *
     * @param uri
     * @param rel
     * @param page
     * @param size
     * @return
     */
    public static String createLinkHeader(final String uri, final String rel, final int page, final int size) {
        return String.format("<%s?page=%d&pageSize=%d>; rel=\"%s\"", uri, page, size, rel);
    }

    /**
     * get the list of all the enrollment that exist
     * @return
     */

    public ResponseEntity<List<EnrollmentList>> getEnrollments(@ApiParam(value = "Page number", defaultValue = "1")
            @Valid @RequestParam(value = "page", required = false, defaultValue="1") Integer page,
                                                           @ApiParam(value = "number of elements per page", defaultValue = "20") @Valid @RequestParam(value = "pageSize",
                        required = false, defaultValue="20") Integer pageSize) {

        final StringBuilder linkHeader = new StringBuilder();

        String admin = httpServletRequest.getAttribute("role").toString();
        String mail = httpServletRequest.getAttribute("email").toString();


        Long monbreTotalEnrollments = enrollmentsRepository.count();
        Long NombrePageTotal = monbreTotalEnrollments/pageSize +  ((monbreTotalEnrollments%pageSize == 0 ) ? 0 : + 1);

        if(page < NombrePageTotal - 1){
            linkHeader.append(createLinkHeader(httpServletRequest.getRequestURI(), "Next", page, pageSize));

        }

        if(page > 0){
            if(linkHeader.length()>0)
                linkHeader.append(",");
            linkHeader.append(createLinkHeader(httpServletRequest.getRequestURI(), "Prev", page, pageSize));
        }

        if(page != 1){
            if(linkHeader.length()>0)
                linkHeader.append(",");
            linkHeader.append(createLinkHeader(httpServletRequest.getRequestURI(), "first", page, pageSize));
        }

        if(page.longValue()!= NombrePageTotal) {
            if (linkHeader.length() > 0)
                linkHeader.append(",");
            linkHeader.append(createLinkHeader(httpServletRequest.getRequestURI(), "Last", page, pageSize));
        }

        List<EnrollmentList> enrollments;

        if(admin.equals("admin")) {

             enrollments = enrollmentsRepository.findAll(PageRequest.of(page - 1, pageSize)).parallelStream().
                    map(EnrollmentsApiController::toEnrollentList).collect(Collectors.toList());
        }
        else{
                        enrollments = enrollmentsRepository.findAllByEmail(PageRequest.of(page - 1, pageSize), mail ).parallelStream().
                    map(EnrollmentsApiController::toEnrollentList).collect(Collectors.toList());
        }

        return ResponseEntity.ok().header(HttpHeaders.LINK, linkHeader.toString()).body(enrollments);
    }


    /**
     * Modification d'un enrollment
     * @param id de l'enrollment à modifier   
     * @param enrollment
     * @return
     */
    public ResponseEntity<Enrollment> updateEnrollment(@ApiParam(value = "",required=true) @PathVariable("id") Integer id,
                                                       @ApiParam(value = "" ,required=true )  @Valid @RequestBody Enrollment enrollment) {


        EnrollmentEntity enrollmentEntity = enrollmentsRepository.findById(id.longValue()).get();
        String mail = httpServletRequest.getAttribute("email").toString();
        if(enrollmentEntity != null){
            enrollmentEntity.setEmail(mail);
            enrollmentEntity.getSubject().setId(enrollment.getSubjectId()); //
        }
        EnrollmentEntity saveEnrollmentEntity = enrollmentsRepository.save(enrollmentEntity);//JPA ME RENVOIT L'OBJET PERSISTE
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(saveEnrollmentEntity.getId()).toUri();

        return ResponseEntity.created(location).body(toEnrollment(saveEnrollmentEntity));
    }

    /**
     * delete an existing enrollment
     * @param id of the enrollment to delete
     * @return
     */
    public ResponseEntity<Void> deleteEnrollment(@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "nameSubject", required = true) String nameSubject)  {
        String mail = httpServletRequest.getAttribute("email").toString();
        SubjectEntity subjectEntity = subjectRepository.findByName(nameSubject);
        if (subjectEntity != null && (enrollmentsRepository.findByEmailAndAndSubject(mail, subjectEntity))!=null) {
            enrollmentsRepository.deleteByEmailAndAndSubject(mail, subjectEntity);
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }

    /**
     * convert an enrollment to an entity
     * @param enrollment to convert
     * @return an entity
     */
    private EnrollmentEntity toEnrollmentEntity(Enrollment enrollment) {
        EnrollmentEntity entity = new EnrollmentEntity();
        Optional<SubjectEntity> subject = subjectRepository.findById(enrollment.getSubjectId());
        entity.setSubject(subject.get());

        return entity;
    }

    /**
     * convert and entity to an enrollment
     * @param entity
     * @return an enrollement
     */
    private static Enrollment toEnrollment(EnrollmentEntity entity) {
        Enrollment enrollment = new Enrollment();
        enrollment.setSubjectId(entity.getSubject().getId());
        return enrollment;
    }

    /**
     *
     * @param entity
     * @return
     */
    private static EnrollmentList toEnrollentList(EnrollmentEntity entity) {
        EnrollmentList enrollment = new EnrollmentList();
        enrollment.setId(entity.getId());
        enrollment.setSubjectId(entity.getSubject().getId());
        enrollment.setEmail(entity.getEmail());
        enrollment.setName(entity.getSubject().getName());
        return enrollment;
    }
}
