package ch.heigvd.amt.gestioncours.api.endpoints;

import ch.heigvd.amt.gestioncours.api.ApiUtil;
import ch.heigvd.amt.gestioncours.api.EnrollmentsApi;
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
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class EnrollmentsApiController implements EnrollmentsApi  {

    @Autowired
    EnrollmentRepository enrollmentsRepository;

    @Autowired
    SubjectRepository subjectRepository;

    public ResponseEntity<Void> createEnrollment(@ApiParam(value = "" ,required=true )  @Valid @RequestBody Enrollment enrollment) {
        EnrollmentEntity newEnrollementEntity = toEnrollmentEntity(enrollment);
        enrollmentsRepository.save(newEnrollementEntity);
        Long id = newEnrollementEntity.getId();

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(newEnrollementEntity.getId()).toUri();

        return ResponseEntity.created(location).build();

    }

    public ResponseEntity<Void> deleteEnrollment(@ApiParam(value = "",required=true) @PathVariable("id") Integer id) {
        EnrollmentEntity enrollmentEntity = enrollmentsRepository.findById(id.longValue()).get();

        if (enrollmentEntity != null) {
            enrollmentsRepository.delete(enrollmentEntity);
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }


    public ResponseEntity<List<EnrollmentList>> getEnrollments() {
        List<EnrollmentList> enrollments = new ArrayList<>();
        for (EnrollmentEntity enrollmentEntity : enrollmentsRepository.findAll()) {
            enrollments.add(toEnrollentList(enrollmentEntity));
        }

        return ResponseEntity.ok(enrollments);
    }


    private EnrollmentEntity toEnrollmentEntity(Enrollment enrollment) {
        EnrollmentEntity entity = new EnrollmentEntity();
        entity.setStudent_email(enrollment.getStudentEmail());

        Optional<SubjectEntity> subject = subjectRepository.findById(enrollment.getSubjectId());
        entity.setSubject(subject.get());

        return entity;
    }


    private EnrollmentList toEnrollentList(EnrollmentEntity entity) {
        EnrollmentList enrollment = new EnrollmentList();
        enrollment.setId(entity.getId());
        enrollment.setSubjectId(entity.getSubject().getId());
        enrollment.setStudentEmail(entity.getStudent_email());
        return enrollment;
    }

}
