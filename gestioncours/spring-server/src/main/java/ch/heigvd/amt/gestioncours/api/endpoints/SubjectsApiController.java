package ch.heigvd.amt.gestioncours.api.endpoints;

import ch.heigvd.amt.gestioncours.api.SubjectsApi;
import ch.heigvd.amt.gestioncours.api.model.Labo;
import ch.heigvd.amt.gestioncours.api.model.Subject;
import ch.heigvd.amt.gestioncours.entities.SubjectEntity;
import ch.heigvd.amt.gestioncours.repositories.LaboRepository;
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
import javax.validation.constraints.Min;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class SubjectsApiController implements SubjectsApi {

    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    LaboRepository laboRepository;
    HttpServletRequest httpServletRequest;


    /**
     *
     * @param subject
     * @return
     */
    public ResponseEntity<Subject> createSubject(@ApiParam(value = "" ,required=true )  @Valid @RequestBody Subject subject) {

        SubjectEntity newSubjectEntity = toSubjectEntity(subject);
        SubjectEntity saveSubject = subjectRepository.save(newSubjectEntity);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(saveSubject.getId()).toUri();
        return ResponseEntity.created(location).body(toSubject(saveSubject));
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
     *
     * @return
     */
    public ResponseEntity<List<Subject>> getSubjects(@ApiParam(value = "Page number", defaultValue = "1")
                @Valid @RequestParam(value = "page", required = false, defaultValue="1") Integer page,
                @ApiParam(value = "number of elements per page", defaultValue = "20")
                @Valid @RequestParam(value = "pageSize", required = false, defaultValue="20") Integer pageSize)  {

        final StringBuilder linkHeader = new StringBuilder();

        Long monbreTotalSubjects = subjectRepository.count();
        Long NombrePageTotal = monbreTotalSubjects/pageSize +  ((monbreTotalSubjects%pageSize == 0 ) ? 0 : + 1);

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

        List<Subject> subjects = subjectRepository.findAll(PageRequest.of(page-1, pageSize)).parallelStream().
                map(SubjectsApiController:: toSubject).collect(Collectors.toList());


        return ResponseEntity.ok().header(HttpHeaders.LINK, linkHeader.toString()).body(subjects);
    }

    /**
     *
     * @param id
     * @return
     */
    public ResponseEntity<Subject> getASubject(@Min(1L)@ApiParam(value = "",required=true) @PathVariable("id") Long id) {

        return ResponseEntity.ok(toSubject(subjectRepository.findById(id.longValue()).get()));
    }


    /**
     *
     * @param id
     * @param subject
     * @return
     */
    public ResponseEntity<Subject> updateSubject(@ApiParam(value = "",required=true) @PathVariable("id") Integer id,@ApiParam(value = "" ,required=true )  @Valid @RequestBody Subject subject) {
        Optional<SubjectEntity> subjectEntity = subjectRepository.findById(id.longValue());
        if(!subjectEntity.isPresent()) {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        subjectEntity.get().setCredits_etcs(subject.getCreditsEtcs());
        subjectEntity.get().setName(subject.getName());
        SubjectEntity saveSubject = subjectRepository.save(subjectEntity.get());
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(saveSubject.getId()).toUri();
        return ResponseEntity.created(location).body(toSubject(saveSubject));


    }

    /**
     *
     * @param id
     * @return
     */
    public ResponseEntity<Void> deleteSubject(@ApiParam(value = "",required=true) @PathVariable("id") Integer id) {
        SubjectEntity subjectEntity = subjectRepository.findById(id.longValue()).get();

        if (subjectEntity != null) {
            subjectRepository.delete(subjectEntity);
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    /**
     *
     * @param subject
     * @return
     */
    private SubjectEntity toSubjectEntity(Subject subject){
        SubjectEntity entity = new SubjectEntity();
        entity.setName(subject.getName());
        entity.setCredits_etcs(subject.getCreditsEtcs());
        entity.setLabo(laboRepository.findById(subject.getLaboId()).get());
        return entity;
    }

    /**
     *
     * @param entity
     * @return
     */
    private static Subject toSubject(SubjectEntity entity) {
        Subject subject = new Subject();
        subject.setCreditsEtcs(entity.getCredits_etcs());
        subject.setName(entity.getName());
        subject.setId(entity.getId());
        subject.setLaboId(entity.getLabo().getId());
        return subject;
    }

}
