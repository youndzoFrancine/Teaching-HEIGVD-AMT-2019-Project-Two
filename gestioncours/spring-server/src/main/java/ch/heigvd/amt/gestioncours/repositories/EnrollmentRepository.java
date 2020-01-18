package ch.heigvd.amt.gestioncours.repositories;

import ch.heigvd.amt.gestioncours.entities.EnrollmentEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;


import java.util.List;

public interface EnrollmentRepository extends CrudRepository<EnrollmentEntity, Long> {

    List<EnrollmentEntity> findAll(Pageable pageable);

}
