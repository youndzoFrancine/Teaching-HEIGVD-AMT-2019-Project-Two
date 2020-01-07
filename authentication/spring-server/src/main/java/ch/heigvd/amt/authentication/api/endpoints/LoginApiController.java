package ch.heigvd.amt.authentication.api.endpoints;

import ch.heigvd.amt.authentication.api.LoginApi;
import ch.heigvd.amt.authentication.api.model.Credentials;
import ch.heigvd.amt.authentication.api.model.Token;
import ch.heigvd.amt.authentication.security.TokenServices;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class LoginApiController implements LoginApi {

    TokenServices tokenServices;
    public ResponseEntity<Token> login(@ApiParam(value = ""  )  @Valid @RequestBody Credentials credentials){

        //check if mandatory fields are provide
        if(credentials.getEmail() == null || credentials.getPassword() == null){
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }

        else {
            Token token = tokenServices.createToken(credentials);
            return ResponseEntity.ok(token);
        }
    }


}
