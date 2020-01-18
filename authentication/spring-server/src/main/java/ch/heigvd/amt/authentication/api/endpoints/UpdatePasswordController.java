package ch.heigvd.amt.authentication.api.endpoints;


import ch.heigvd.amt.authentication.api.UpdatePasswordApi;
import ch.heigvd.amt.authentication.api.exceptions.AuthenticationFailedException;
import ch.heigvd.amt.authentication.api.exceptions.UserDoesNotExistException;
import ch.heigvd.amt.authentication.api.model.ResetPwrd;
import ch.heigvd.amt.authentication.api.util.PasswordUtile;
import ch.heigvd.amt.authentication.entities.UserEntity;
import ch.heigvd.amt.authentication.repositories.UserRepository;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UpdatePasswordController implements UpdatePasswordApi {

    @Autowired
    UserRepository userRepository;

    public ResponseEntity<Void> resetPassword(@ApiParam(value = ""  )  @Valid @RequestBody ResetPwrd resetPwrd) {

        UserEntity user = userRepository.findByEmail(resetPwrd.getEmail());

        if(user != null){
            if(!(PasswordUtile.isPasswordValid(resetPwrd.getOldPswrd(), user.getPassword(), user.getSalt()))){
                throw new AuthenticationFailedException();
            }
            user.setPassword(resetPwrd.getNewPswrd());
            userRepository.save(user);
            return  ResponseEntity.accepted().build();
        }
      throw new UserDoesNotExistException();
    }
}
