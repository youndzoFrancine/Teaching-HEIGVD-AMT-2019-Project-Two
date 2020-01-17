package ch.heigvd.amt.authentication.repositories;

import ch.heigvd.amt.authentication.entities.UserEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by OCrescence Yimnaing on 16/12/19.
 */
public interface UserRepository extends CrudRepository<UserEntity, Long>{
    UserEntity findByEmail(@Param("email") String email);
    List<UserEntity> findAll(Pageable pageable);
}
