package ch.heigvd.amt.authentication.api.endpoints;

import ch.heigvd.amt.authentication.api.UsersApi;

import ch.heigvd.amt.authentication.api.model.User;
import ch.heigvd.amt.authentication.api.model.UserWithId;
import ch.heigvd.amt.authentication.entities.UserEntity;
import ch.heigvd.amt.authentication.repositories.UserRepository;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UsersApiController implements UsersApi {

    private UserEntity toUserEntity(User user){
        UserEntity entity = new UserEntity();
        entity.setFirstname(user.getFirstname());
        entity.setLastname(user.getLastname());
        entity.setPassword(user.getPassword());
        entity.setEmail(user.getEmail());
        entity.setRole(user.getRole());
        return entity;
    }

    private UserWithId toUserWithId(UserEntity userEntity) {
        UserWithId user = new UserWithId();
        user.setEmail(userEntity.getEmail());
        user.setFirstname(userEntity.getFirstname());
        user.setLastname(userEntity.getLastname());
        user.setRole(userEntity.getRole());
        user.setPassword(userEntity.getPassword());
        user.setId(userEntity.getId());
        return user;
    }

    @Autowired
    UserRepository userRepository;

    public ResponseEntity<Void> createUser(@ApiParam(value = "", required = true) @Valid @RequestBody User user) {
        UserEntity newUserEntity = toUserEntity(user);
        userRepository.save(newUserEntity);
        Long id = newUserEntity.getId();

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("{id}")
                .buildAndExpand(newUserEntity.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    public ResponseEntity<List<UserWithId>> getUsers(){
        List<UserWithId> users = new ArrayList<>();
        for (UserEntity userEntity : userRepository.findAll()) {
            users.add(toUserWithId(userEntity));
        }
        return ResponseEntity.ok(users);
    }

}