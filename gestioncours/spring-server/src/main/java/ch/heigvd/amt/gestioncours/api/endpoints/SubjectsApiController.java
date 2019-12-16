package ch.heigvd.amt.gestioncours.api.endpoints;

import ch.heigvd.amt.gestioncours.api.SubjectsApi;
import ch.heigvd.amt.gestioncours.api.model.Subject;
import ch.heigvd.amt.gestioncours.api.model.SubjectList;
import ch.heigvd.amt.gestioncours.entities.SubjectEntity;
import ch.heigvd.amt.gestioncours.repositories.SubjectRepository;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
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

    private SubjectEntity toSubjectEntity(Subject subject){
        SubjectEntity entity = new SubjectEntity();
        entity.setName(subject.getName());
        entity.setCredits_etcs(subject.getCreditsEtcs());
        return entity;
    }

    private SubjectList toSubject(SubjectEntity entity) {
        SubjectList subject = new SubjectList();
        subject.setCreditsEtcs(entity.getCredits_etcs());
        subject.setName(entity.getName());
        subject.setId(entity.getId());
        return subject;
    }

   /* private SubjectList toSubjectList(Optional<SubjectEntity> subjectEntity) {
        SubjectList subject = new SubjectList();
        //subject.setCreditsEtcs(toSubjectList(subjectEntity).getCreditsEtcs());
       // subject.setName(toSubjectList(subjectEntity).getName());
        //subject.setId(toSubjectList(subjectEntity).getId());

        subject.setCreditsEtcs(toSubject(subjectEntity));

        return subject;
    }*/

    @Autowired
    SubjectRepository subjectRepository;

    public ResponseEntity<Void> createSubject(@ApiParam(value = "" ,required=true )  @Valid @RequestBody Subject subject) {

        SubjectEntity newSubjectEntity = toSubjectEntity(subject);
        subjectRepository.save(newSubjectEntity);
        Long id = newSubjectEntity.getId();

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(newSubjectEntity.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    public ResponseEntity<List<SubjectList>> getSubjects() {
        List<SubjectList> subjects = new ArrayList<>();
        for (SubjectEntity subjectEntity : subjectRepository.findAll()) {
            subjects.add(toSubject(subjectEntity));
        }
        return ResponseEntity.ok(subjects);
    }

    public ResponseEntity<SubjectList> getASubject(@Min(1L)@ApiParam(value = "",required=true) @PathVariable("id") Long id) {

        SubjectList subject =new SubjectList();
        for (SubjectEntity subjectEntity : subjectRepository.findAll()) {
           if(subjectEntity.getId() == id){
               subject = toSubject(subjectEntity);
               break;
           }
        }
        return ResponseEntity.ok(subject);
    }

}
