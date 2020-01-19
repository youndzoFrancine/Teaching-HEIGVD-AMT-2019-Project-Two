package ch.heigvd.amt.gestioncours.repositories;

import ch.heigvd.amt.gestioncours.entities.LaboEntity;
import ch.heigvd.amt.gestioncours.entities.SubjectEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by OCrescence Yimnaing on 12/12/19.
 */
public interface SubjectRepository extends CrudRepository<SubjectEntity, Long>{

    SubjectEntity findByName(@Param("name") String name);

     SubjectEntity findByid(Long id);
    List<SubjectEntity> findAll(Pageable pageable);
    SubjectEntity findByLaboEntity(LaboEntity laboEntity);
}
