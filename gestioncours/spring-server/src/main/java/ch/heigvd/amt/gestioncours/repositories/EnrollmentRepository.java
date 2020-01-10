package ch.heigvd.amt.gestioncours.repositories;

import ch.heigvd.amt.gestioncours.entities.EnrollmentEntity;
import org.springframework.data.repository.CrudRepository;

public interface EnrollmentRepository extends CrudRepository<EnrollmentEntity, Long> {
}
