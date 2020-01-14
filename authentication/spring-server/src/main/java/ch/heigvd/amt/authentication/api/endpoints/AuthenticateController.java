package ch.heigvd.amt.authentication.api.endpoints;

import ch.heigvd.amt.authentication.api.LoginApi;
import ch.heigvd.amt.authentication.api.exceptions.AuthenticationFailedException;
import ch.heigvd.amt.authentication.api.exceptions.UserDoesNotExistException;
import ch.heigvd.amt.authentication.api.model.Credentials;
import ch.heigvd.amt.authentication.api.util.JWTutils;
import ch.heigvd.amt.authentication.api.util.PasswordUtile;
import ch.heigvd.amt.authentication.api.util.URIs;
import ch.heigvd.amt.authentication.entities.UserEntity;
import ch.heigvd.amt.authentication.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Paths;

@RestController
@RequestMapping(URIs.AUTH)

public class AuthenticateController implements LoginApi, ApplicationRunner {

    @Autowired
    private  UserRepository userRepository;

    public AuthenticateController() {}

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> login(@Valid @RequestBody Credentials credentials) {
        UserEntity user1 = new UserEntity();
        user1.setLastname("Joseph");
        user1.setFirstname("kamdem");
        user1.setEmail("kj@gmail.com");
        user1.setPassword("12345");
        user1.setRole("admin");
        userRepository.save(user1);
        System.out.println(userRepository);
        UserEntity user = userRepository.findByEmail(credentials.getEmail());
        System.out.println(userRepository.findByEmail(credentials.getEmail()));
        if(user==null){
            throw new UserDoesNotExistException();
        }

        if(!PasswordUtile.isPasswordValid(credentials.getPassword(), user.getPassword(), user.getSalt())){
            throw new AuthenticationFailedException();
        }
        System.out.println(JWTutils.generateToken(user));

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

}
