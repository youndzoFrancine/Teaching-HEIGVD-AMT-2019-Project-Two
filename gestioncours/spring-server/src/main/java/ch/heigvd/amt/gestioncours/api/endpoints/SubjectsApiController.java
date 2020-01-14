package ch.heigvd.amt.gestioncours.api.endpoints;

import ch.heigvd.amt.gestioncours.api.ApiUtil;
import ch.heigvd.amt.gestioncours.api.SubjectsApi;
import ch.heigvd.amt.gestioncours.api.model.Subject;
import ch.heigvd.amt.gestioncours.api.model.SubjectList;
import ch.heigvd.amt.gestioncours.entities.EnrollmentEntity;
import ch.heigvd.amt.gestioncours.entities.SubjectEntity;
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
import javax.validation.constraints.Min;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class SubjectsApiController implements SubjectsApi {

    @Autowired
    SubjectRepository subjectRepository;

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
     * @return
     */
    public ResponseEntity<List<Subject>> getSubjects() {
        List<Subject> subjects = new ArrayList<>();
        for (SubjectEntity subjectEntity : subjectRepository.findAll()) {
            subjects.add(toSubject(subjectEntity));
        }
        return ResponseEntity.ok(subjects);
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
        return entity;
    }

    /**
     *
     * @param entity
     * @return
     */
    private Subject toSubject(SubjectEntity entity) {
        Subject subject = new Subject();
        subject.setCreditsEtcs(entity.getCredits_etcs());
        subject.setName(entity.getName());
        subject.setId(entity.getId());
        return subject;
    }

}
