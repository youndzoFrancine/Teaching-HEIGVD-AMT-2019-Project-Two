package ch.heigvd.amt.authentication.api.endpoints;

import ch.heigvd.amt.authentication.api.ResetPasswordApi;
import ch.heigvd.amt.authentication.api.util.EmailService;
import ch.heigvd.amt.authentication.entities.UserEntity;
import ch.heigvd.amt.authentication.repositories.UserRepository;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Random;

@RestController
public class ResetPasswordController implements ResetPasswordApi {

    @Autowired
    EmailService emailService;

    @Autowired
    UserRepository userRepository;

    int leftLimit = 48; // numeral '0'
    int rightLimit = 122; // letter 'z'
    int targetStringLength = 10;
    Random random = new Random();

    public  ResponseEntity<Void> forgotPassword(@ApiParam(value = ""  )  @Valid @RequestBody String body) {

        UserEntity  user = userRepository.findByEmail(body);
        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        if(user != null){
            emailService.sendMail(user.getEmail(), "Complete Password Reset!", "To connect to your account you can use the code: "+
                    generatedString + " as the new password");
            user.setPassword(generatedString);
            userRepository.save(user);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.ok().build();
    }


}
