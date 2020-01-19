package ch.heigvd.amt.gestioncours.repositories;

import ch.heigvd.amt.gestioncours.entities.EnrollmentEntity;
import ch.heigvd.amt.gestioncours.entities.SubjectEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface EnrollmentRepository extends CrudRepository<EnrollmentEntity, Long> {

    List<EnrollmentEntity> findAll(Pageable pageable);

    List<EnrollmentEntity> findAllByEmail(Pageable pageable, String mail);

        @Transactional
       void deleteByEmailAndAndSubject(String mail, SubjectEntity sub);

       EnrollmentEntity findByEmailAndAndSubject(String mail, SubjectEntity sub);


}
