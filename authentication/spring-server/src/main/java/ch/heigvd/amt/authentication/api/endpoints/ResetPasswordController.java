package ch.heigvd.amt.authentication.api.endpoints;


import ch.heigvd.amt.authentication.api.ResetPasswordApi;
import ch.heigvd.amt.authentication.api.util.EmailService;
import ch.heigvd.amt.authentication.entities.UserEntity;
import ch.heigvd.amt.authentication.repositories.UserRepository;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ResetPasswordController implements ResetPasswordApi {

    @Autowired
    UserRepository userRepository;

    @Autowired
    EmailService emailService;
    private final int Min = 1000;
    private final int Max = 99871;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> forgotPassword(@ApiParam(value = ""  )  @Valid @RequestBody String body) {

        UserEntity  user = userRepository.findByEmail(body);
        System.out.println(user);

        if(user != null){

            int nombreAleatoire = Min + (int)(Math.random() * ((Max - Min) + 1));
            emailService.sendMail(user.getEmail(), "Complete Password Reset!", "To complete the password reset process, please click here: \"\n" +
                    "                    + \"http://localhost:8080/authentication/swagger-ui.html#/reset-password-controller/resetPassword and enter the code in field OldPassword :  " +
                    Integer.toString(nombreAleatoire));

            return ResponseEntity.ok().build();

        }
        return ResponseEntity.ok().build();
    }


}

