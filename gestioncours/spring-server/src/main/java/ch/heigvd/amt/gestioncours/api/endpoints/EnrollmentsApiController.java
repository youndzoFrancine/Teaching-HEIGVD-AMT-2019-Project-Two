package ch.heigvd.amt.gestioncours.api.endpoints;

import ch.heigvd.amt.gestioncours.api.ApiUtil;
import ch.heigvd.amt.gestioncours.api.EnrollmentsApi;
import ch.heigvd.amt.gestioncours.api.exceptions.EnrollmentNotFounExceptions;
import ch.heigvd.amt.gestioncours.api.model.Enrollment;
import ch.heigvd.amt.gestioncours.api.model.EnrollmentList;
import ch.heigvd.amt.gestioncours.entities.EnrollmentEntity;
import ch.heigvd.amt.gestioncours.entities.SubjectEntity;
import ch.heigvd.amt.gestioncours.repositories.EnrollmentRepository;
import ch.heigvd.amt.gestioncours.repositories.SubjectRepository;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestController
public class EnrollmentsApiController implements EnrollmentsApi  {

    @Autowired
    EnrollmentRepository enrollmentsRepository;

    @Autowired
    SubjectRepository subjectRepository;

    /**
     * create a new enrollment to post
     * @param enrollment the paramater to post
     * @return
     */
    public ResponseEntity<Void> createEnrollment(@ApiParam(value = "" ,required=true )  @Valid @RequestBody Enrollment enrollment) {
        EnrollmentEntity newEnrollementEntity = toEnrollmentEntity(enrollment);
        enrollmentsRepository.save(newEnrollementEntity);
        Long id = newEnrollementEntity.getId();

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(newEnrollementEntity.getId()).toUri();

        return ResponseEntity.created(location).build();

    }

    /**
     * get an enrollment base on the id supplied
     * @param id of the enrollment
     * @return
     */
    public ResponseEntity<Enrollment> getEnrollmentById(@ApiParam(value = "ID of enrollment to fetch",required=true) @PathVariable("id") Integer id) {

        EnrollmentEntity enrollmentEntity = enrollmentsRepository.findById(id.longValue()).get();
            if(enrollmentEntity == null){
             throw new EnrollmentNotFounExceptions();
        }
        return ResponseEntity.ok(toEnrollment(enrollmentEntity));

    }

    /**
     * get the list of all the enrollment that exist
     * @return
     */
    public ResponseEntity<List<EnrollmentList>> getEnrollments() {
        List<EnrollmentList> enrollments = new ArrayList<>();
        for (EnrollmentEntity enrollmentEntity : enrollmentsRepository.findAll()) {
            enrollments.add(toEnrollentList(enrollmentEntity));
        }
        return ResponseEntity.ok(enrollments);
    }


    /**
     * delete an existing enrollment
     * @param id of the enrollment to delete
     * @return
     */
    public ResponseEntity<Void> deleteEnrollment(@ApiParam(value = "",required=true) @PathVariable("id") Integer id) {
        EnrollmentEntity enrollmentEntity = enrollmentsRepository.findById(id.longValue()).get();

        if (enrollmentEntity != null) {
            enrollmentsRepository.delete(enrollmentEntity);
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }

    /**
     * update an existing enrollment
     * @param userEmail the email of the user
     * @param subjectId the subject id
     * @return
     */
    public ResponseEntity<Enrollment> updateEnrollment(@ApiParam(value = "",required=true) @PathVariable("user_email") String userEmail,@ApiParam(value = "",required=true) @PathVariable("subject_id") Integer subjectId) {

       // EnrollmentEntity enrollmentEntity = enrollmentsRepository.findById(subjectId.longValue()).get();

        //if(enrollmentEntity!=null){
           // enrollmentEntity.setUser_email();
           // enrollmentEntity.setSubject();
        //}
        return new ResponseEntity<>(HttpStatus.OK);

    }

    /**
     * convert an enrollment to an entity
     * @param enrollment to convert
     * @return an entity
     */
    private EnrollmentEntity toEnrollmentEntity(Enrollment enrollment) {
        EnrollmentEntity entity = new EnrollmentEntity();
        entity.setUser_email(enrollment.getUserEmail());

        Optional<SubjectEntity> subject = subjectRepository.findById(enrollment.getSubjectId());
        entity.setSubject(subject.get());

        return entity;
    }


    /**
     * convert and entity to an enrollment
     * @param entity
     * @return an enrollement
     */
    private Enrollment toEnrollment(EnrollmentEntity entity) {
        Enrollment enrollment = new Enrollment();
        enrollment.setSubjectId(entity.getSubject().getId());
        enrollment.setUserEmail(entity.getUser_email());
        return enrollment;
    }

    /**
     *
     * @param entity
     * @return
     */
    private EnrollmentList toEnrollentList(EnrollmentEntity entity) {
        EnrollmentList enrollment = new EnrollmentList();
        enrollment.setId(entity.getId());
        enrollment.setSubjectId(entity.getSubject().getId());
        enrollment.setUserEmail(entity.getUser_email());
        return enrollment;
    }

}
