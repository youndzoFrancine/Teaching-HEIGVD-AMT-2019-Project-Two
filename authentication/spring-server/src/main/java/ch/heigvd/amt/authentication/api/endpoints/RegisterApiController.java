package ch.heigvd.amt.authentication.api.endpoints;

import ch.heigvd.amt.authentication.api.RegisterApi;
import ch.heigvd.amt.authentication.api.model.User;
import ch.heigvd.amt.authentication.api.util.UserUtils;
import ch.heigvd.amt.authentication.entities.UserEntity;
import ch.heigvd.amt.authentication.repositories.UserRepository;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URI;
@RestController
public class RegisterApiController implements RegisterApi {

    @Autowired
    UserRepository userRepository;
    @Autowired
    HttpServletRequest httpServletRequest;

    public ResponseEntity<User> createUser(@ApiParam(value = "" ,required=true )  @Valid @RequestBody User user) {
        UserEntity newUserEntity = UserUtils.toUserEntity(user);
        UserEntity saveUserEntity = userRepository.save(newUserEntity);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("{email}")
                .buildAndExpand(newUserEntity.getEmail()).toUri();
        return ResponseEntity.created(location).body(UserUtils.toUser(saveUserEntity));
    }
}
