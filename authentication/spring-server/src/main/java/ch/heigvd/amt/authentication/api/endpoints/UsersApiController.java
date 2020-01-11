package ch.heigvd.amt.authentication.api.endpoints;

import ch.heigvd.amt.authentication.api.UsersApi;
import ch.heigvd.amt.authentication.api.model.User;
import ch.heigvd.amt.authentication.api.util.URIs;
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
@RequestMapping(URIs.CREATE_USER)
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

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(@ApiParam(value = "", required = true) @Valid @RequestBody User user) {
        UserEntity newUserEntity = toUserEntity(user);
        userRepository.save(newUserEntity);
        String email = newUserEntity.getEmail();

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("{email}")
                .buildAndExpand(newUserEntity.getEmail()).toUri();
        return ResponseEntity.created(location).build();
    }

    //@RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> getUsers(){
        List<User> users = new ArrayList<>();
        for (UserEntity userEntity : userRepository.findAll()) {
            users.add(toUser(userEntity));
        }
        return ResponseEntity.ok(users);
    }

    @RequestMapping(value = "/{e_mail}/block", method = RequestMethod.PATCH)
    public ResponseEntity<Void> blockUser(@ApiParam(value = "",required=true) @PathVariable("e_mail") String eMail) {
            UserEntity userEntity = userRepository.findByEmail(eMail);
            userEntity.setBlocked(false);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/{e_mail}/unblock", method = RequestMethod.PATCH)
    public ResponseEntity<Void> unblockUser(@ApiParam(value = "",required=true) @PathVariable("e_mail") String eMail) {
        UserEntity userEntity = userRepository.findByEmail(eMail);
        userEntity.setBlocked(true);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);

    }

}