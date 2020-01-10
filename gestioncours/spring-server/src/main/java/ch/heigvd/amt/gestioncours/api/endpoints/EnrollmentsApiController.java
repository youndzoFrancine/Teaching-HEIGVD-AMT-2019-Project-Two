package ch.heigvd.amt.gestioncours.api.endpoints;

<<<<<<< HEAD
import ch.heigvd.amt.gestioncours.api.ApiUtil;
import ch.heigvd.amt.gestioncours.api.EnrollmentsApi;
=======
import ch.heigvd.amt.gestioncours.api.EnrollmentsApi;
import ch.heigvd.amt.gestioncours.api.exceptions.EnrollmentNotFounExceptions;
>>>>>>> 63dd7b6021b3903ddab9bf1535649138ff826dc5
import ch.heigvd.amt.gestioncours.api.model.Enrollment;
import ch.heigvd.amt.gestioncours.api.model.EnrollmentList;
import ch.heigvd.amt.gestioncours.entities.EnrollmentEntity;
import ch.heigvd.amt.gestioncours.entities.SubjectEntity;
import ch.heigvd.amt.gestioncours.repositories.EnrollmentRepository;
import ch.heigvd.amt.gestioncours.repositories.SubjectRepository;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
<<<<<<< HEAD
import org.springframework.http.MediaType;
=======
>>>>>>> 63dd7b6021b3903ddab9bf1535649138ff826dc5
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
<<<<<<< HEAD
import org.springframework.web.context.request.NativeWebRequest;
=======
>>>>>>> 63dd7b6021b3903ddab9bf1535649138ff826dc5
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

<<<<<<< HEAD
=======
import static org.springframework.http.HttpStatus.BAD_REQUEST;

>>>>>>> 63dd7b6021b3903ddab9bf1535649138ff826dc5
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

<<<<<<< HEAD
    public ResponseEntity<Void> deleteEnrollment(@ApiParam(value = "",required=true) @PathVariable("id") Integer id) {
        EnrollmentEntity enrollmentEntity = enrollmentsRepository.findById(id.longValue()).get();

        if (enrollmentEntity != null) {
            enrollmentsRepository.delete(enrollmentEntity);
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }


=======


    public ResponseEntity<Enrollment> getEnrollmentById(@ApiParam(value = "ID of enrollment to fetch",required=true) @PathVariable("id") Integer id) {

        EnrollmentEntity enrollmentEntity = enrollmentsRepository.findById(id.longValue()).get();
            if(enrollmentEntity == null){
             throw new EnrollmentNotFounExceptions();
        }
        return ResponseEntity.ok(toEnrollent(enrollmentEntity));

    }

>>>>>>> 63dd7b6021b3903ddab9bf1535649138ff826dc5
    public ResponseEntity<List<EnrollmentList>> getEnrollments() {
        List<EnrollmentList> enrollments = new ArrayList<>();
        for (EnrollmentEntity enrollmentEntity : enrollmentsRepository.findAll()) {
            enrollments.add(toEnrollentList(enrollmentEntity));
        }
<<<<<<< HEAD

        return ResponseEntity.ok(enrollments);
    }


    private EnrollmentEntity toEnrollmentEntity(Enrollment enrollment) {
        EnrollmentEntity entity = new EnrollmentEntity();
        entity.setStudent_email(enrollment.getStudentEmail());
=======
        return ResponseEntity.ok(enrollments);
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

    private EnrollmentEntity toEnrollmentEntity(Enrollment enrollment) {
        EnrollmentEntity entity = new EnrollmentEntity();
        entity.setUser_email(enrollment.getUserEmail());
>>>>>>> 63dd7b6021b3903ddab9bf1535649138ff826dc5

        Optional<SubjectEntity> subject = subjectRepository.findById(enrollment.getSubjectId());
        entity.setSubject(subject.get());

        return entity;
    }


<<<<<<< HEAD
=======
    private Enrollment toEnrollent(EnrollmentEntity entity) {
        Enrollment enrollment = new Enrollment();
        enrollment.setSubjectId(entity.getSubject().getId());
        enrollment.setUserEmail(entity.getUser_email());
        return enrollment;
    }

>>>>>>> 63dd7b6021b3903ddab9bf1535649138ff826dc5
    private EnrollmentList toEnrollentList(EnrollmentEntity entity) {
        EnrollmentList enrollment = new EnrollmentList();
        enrollment.setId(entity.getId());
        enrollment.setSubjectId(entity.getSubject().getId());
<<<<<<< HEAD
        enrollment.setStudentEmail(entity.getStudent_email());
=======
        enrollment.setUserEmail(entity.getUser_email());
>>>>>>> 63dd7b6021b3903ddab9bf1535649138ff826dc5
        return enrollment;
    }

}
