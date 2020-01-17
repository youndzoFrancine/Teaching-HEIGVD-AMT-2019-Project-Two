package ch.heigvd.amt.authentication.api.endpoints;

import ch.heigvd.amt.authentication.api.LoginApi;
import ch.heigvd.amt.authentication.api.exceptions.AuthenticationFailedException;
import ch.heigvd.amt.authentication.api.exceptions.UserDoesNotExistException;
import ch.heigvd.amt.authentication.api.model.Credentials;
import ch.heigvd.amt.authentication.api.util.*;
import ch.heigvd.amt.authentication.entities.UserEntity;
import ch.heigvd.amt.authentication.repositories.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Paths;

@RestController
public class AuthenticateController implements LoginApi, ApplicationRunner {

    @Autowired
    private  UserRepository userRepository;
    @Autowired
    HttpServletRequest httpServletRequest;

    public AuthenticateController() {}

    public ResponseEntity<Void> login(@Valid @RequestBody Credentials credentials) {
        UserEntity user = userRepository.findByEmail(credentials.getEmail());
        if(user==null){
            throw new UserDoesNotExistException();
        }
        if(user.getStatus().equals("block")){
            return  ResponseEntity.status(HttpServletResponse.SC_UNAUTHORIZED).build();
        }
        if(!PasswordUtile.isPasswordValid(credentials.getPassword(), user.getPassword(), user.getSalt())){
            throw new AuthenticationFailedException();
        }

        return ResponseEntity
                .ok()
                .header("Authorization", JWTutils.generateToken(user))
                .build();
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        UserEntity user1 = new UserEntity();


       URL res = getClass().getClassLoader().getResource("data.utf8");
        try (FileInputStream f = new FileInputStream(Paths.get(res.toURI()).toString())){

            InputStreamReader fls = new InputStreamReader(f, "UTF-8");

            try(BufferedReader reader = new BufferedReader(fls)){
                String line = reader.readLine();
                while(line!= null) {
                    UserEntity user = new UserEntity();
                    // System.out.println(line);
                    String str [] = line.split(",");
                    user.setEmail(str[0].replace("\\s", ""));
                    user.setFirstname(str[1].replace("\\s", ""));
                    user.setLastname(str[2].replace("\\s", ""));
                    user.setPassword(str[3].replace("\\s", ""));
                    user.setRole(str[4].replace("\\s", ""));
                    userRepository.save(user);
                    line = reader.readLine();
                }
                System.out.println(userRepository.findByEmail("crescy.kamdem@heig-vd.ch"));
            };
            return;

        } catch (IOException e) {
            e.printStackTrace();
        } ;
    }


    private void sendError(HttpServletResponse response, int status, String errorCode, String message) throws IOException {
        response.setStatus(status);
        response.setHeader("Content-Type", "application/json");

        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(new ErrorDescription(errorCode, message)));
    }
}
