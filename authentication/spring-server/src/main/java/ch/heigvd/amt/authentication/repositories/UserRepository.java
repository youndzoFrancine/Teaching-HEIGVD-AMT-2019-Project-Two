package ch.heigvd.amt.authentication.repositories;

import ch.heigvd.amt.authentication.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by OCrescence Yimnaing on 16/12/19.
 */
public interface UserRepository extends CrudRepository<UserEntity, Long>{

}
