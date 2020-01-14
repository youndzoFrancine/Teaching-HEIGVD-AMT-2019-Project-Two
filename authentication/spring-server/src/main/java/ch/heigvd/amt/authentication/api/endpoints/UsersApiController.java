package ch.heigvd.amt.authentication.api.endpoints;

import ch.heigvd.amt.authentication.api.UsersApi;
import ch.heigvd.amt.authentication.api.model.User;
import ch.heigvd.amt.authentication.entities.UserEntity;
import ch.heigvd.amt.authentication.repositories.UserRepository;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UsersApiController implements UsersApi {

    /**
     * @Brief : convert a User to UserEntity
     * @param user : user to convert
     * @return : userEntity
     */
    private UserEntity toUserEntity(User user){
        UserEntity entity = new UserEntity();
        entity.setFirstname(user.getFirstname());
        entity.setLastname(user.getLastname());
        entity.setPassword(user.getPassword());
        entity.setEmail(user.getEmail());
        entity.setRole(user.getRole());
        return entity;
    }

    /**
     * @Brief : convert an UserEntity to User
     * @param userEntity : userEntity to convert
     * @return : user
     */
    private User toUser(UserEntity userEntity) {
        User user = new User();
        user.setEmail(userEntity.getEmail());
        user.setFirstname(userEntity.getFirstname());
        user.setLastname(userEntity.getLastname());
        user.setRole(userEntity.getRole());
        return user;
    }

    @Autowired
    UserRepository userRepository;

    /**
     *
     * @param user : User to create
     * @return
     */
    public ResponseEntity<User> createUser(@ApiParam(value = "" ,required=true )  @Valid @RequestBody User user){
        UserEntity newUserEntity = toUserEntity(user);
        UserEntity saveUserEntity = userRepository.save(newUserEntity);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("{email}")
                .buildAndExpand(newUserEntity.getEmail()).toUri();
        return ResponseEntity.created(location).body(toUser(saveUserEntity));
    }

    /**
     *
     * @return : a list of all users in our databse
     */
    public ResponseEntity<List<User>> getUsers(){
        List<User> users = new ArrayList<>();
        for (UserEntity userEntity : userRepository.findAll()) {
            users.add(toUser(userEntity));
        }
        return ResponseEntity.ok(users);
    }

    /**
     *
     * @param eMail : email of user to block
     * @return
     */
    public ResponseEntity<Void> blockUser(@ApiParam(value = "",required=true) @PathVariable("e_mail") String eMail) {
            UserEntity userEntity = userRepository.findByEmail(eMail);
            userEntity.setBlocked(false);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    /**
     *
     * @param eMail
     * @return
     */
    public ResponseEntity<Void> unblockUser(@ApiParam(value = "",required=true) @PathVariable("e_mail") String eMail) {
        UserEntity userEntity = userRepository.findByEmail(eMail);
        userEntity.setBlocked(true);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);

    }

}