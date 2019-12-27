package ch.heigvd.amt.gestioncours.api.endpoints;

import ch.heigvd.amt.gestioncours.api.ApiUtil;
import ch.heigvd.amt.gestioncours.api.EnrollmentsApi;
import ch.heigvd.amt.gestioncours.api.model.Enrollment;
import ch.heigvd.amt.gestioncours.entities.EnrollmentsEntity;
import ch.heigvd.amt.gestioncours.repositories.EnrollmentsRepository;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController

public class EnrollmentsApiController implements EnrollmentsApi {




    @Autowired
    EnrollmentsRepository enrollmentsRepository;

    public ResponseEntity<Void> createEnrollment(@ApiParam(value = "", required = true) @Valid @RequestBody Enrollment enrollment) {
        EnrollmentsEntity newEnrollementEntity = toEnrollmentEntity(enrollment);
        enrollmentsRepository.save(newEnrollementEntity);
        Long id = newEnrollementEntity.getId();

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(newEnrollementEntity.getId()).toUri();

        return ResponseEntity.created(location).build();
    }


    public  ResponseEntity<Void> deleteEnrollment(@ApiParam(value = "",required=true) @PathVariable("id") Long id) {
        Enrollment enrollment = enrollmentsRepository.findEnrollmentById(id);
        EnrollmentsEntity newEnrollementEntity = toEnrollmentEntity(enrollment);

        if (enrollment != null) {
            enrollmentsRepository.delete(newEnrollementEntity);
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }


    public ResponseEntity<List<Enrollment>> getEnrollments() {
        List<Enrollment> enrollments = new ArrayList<>();
        for (EnrollmentsEntity enrollmentEntity : enrollmentsRepository.findAll()) {
            enrollments.add(toEnrollent(enrollmentEntity));
        }

        return ResponseEntity.ok(enrollments);
    }


    private EnrollmentsEntity toEnrollmentEntity(Enrollment enrollment) {
        EnrollmentsEntity entity = new EnrollmentsEntity();
        entity.setStudent_email(enrollment.geteMail());
        entity.setId(enrollment.getSubjectId());
        return entity;
    }


    private Enrollment toEnrollent(EnrollmentsEntity entity) {
        Enrollment enrollment = new Enrollment();
        enrollment.setSubjectId(entity.getId());
        enrollment.seteMail(entity.getStudent_email());
        return enrollment;
    }

}
