package ch.heigvd.amt.gestioncours.repositories;

import ch.heigvd.amt.gestioncours.api.model.Enrollment;
import ch.heigvd.amt.gestioncours.entities.EnrollmentsEntity;
import org.springframework.data.repository.CrudRepository;

public interface EnrollmentsRepository extends CrudRepository<EnrollmentsEntity,Long> {
    public Enrollment findEnrollmentById(Long sujectId);
}
