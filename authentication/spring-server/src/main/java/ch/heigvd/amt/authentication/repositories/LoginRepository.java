package ch.heigvd.amt.authentication.repositories;

import ch.heigvd.amt.authentication.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface LoginRepository extends CrudRepository<UserEntity, Long> {
}
