package ch.heigvd.amt.authentication.api.endpoints;

import ch.heigvd.amt.authentication.api.UsersApi;
import ch.heigvd.amt.authentication.api.model.User;
import ch.heigvd.amt.authentication.entities.UserEntity;
import ch.heigvd.amt.authentication.repositories.UserRepository;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

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

    private static User toUser(UserEntity userEntity) {
        User user = new User();
        user.setEmail(userEntity.getEmail());
        user.setFirstname(userEntity.getFirstname());
        user.setLastname(userEntity.getLastname());
        user.setRole(userEntity.getRole());
        return user;
    }

    @Autowired
    UserRepository userRepository;
    @Autowired
    HttpServletRequest httpServletRequest;

    public ResponseEntity<User> createUser(@ApiParam(value = "" ,required=true )  @Valid @RequestBody User user) {
        UserEntity newUserEntity = toUserEntity(user);
        UserEntity saveUserEntity = userRepository.save(newUserEntity);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("{email}")
                .buildAndExpand(newUserEntity.getEmail()).toUri();
        return ResponseEntity.created(location).body(toUser(saveUserEntity));
    }

    public ResponseEntity<List<User>> getUsers(@ApiParam(value = "Page number", defaultValue = "1") @Valid @RequestParam(value = "page",
            required = false, defaultValue="1") Integer page,@ApiParam(value = "number of elements per page", defaultValue = "20")
            @Valid @RequestParam(value = "pageSize", required = false, defaultValue="20") Integer pageSize){
        final StringBuilder linkHeader = new StringBuilder();

        Long monbreTotalusers = userRepository.count();
        Long NombrePageTotal = monbreTotalusers/pageSize +  ((monbreTotalusers%pageSize == 0 ) ? 0 : + 1);

         if(page < NombrePageTotal - 1){
             linkHeader.append(createLinkHeader(httpServletRequest.getRequestURI(), "Next", page, pageSize));
         }

         if(page > 0){
              if(linkHeader.length()>0)
                  linkHeader.append(",");
             linkHeader.append(createLinkHeader(httpServletRequest.getRequestURI(), "Prev", page, pageSize));
         }

         if(page != 1){
             if(linkHeader.length()>0)
                 linkHeader.append(",");
             linkHeader.append(createLinkHeader(httpServletRequest.getRequestURI(), "first", page, pageSize));
         }

         if(page.longValue()!= NombrePageTotal) {
             if (linkHeader.length() > 0)
                 linkHeader.append(",");
                         linkHeader.append(createLinkHeader(httpServletRequest.getRequestURI(), "Last", page, pageSize));
         }


         List<User> users = userRepository.findAll(PageRequest.of(page -1, pageSize)).parallelStream().
                 map(UsersApiController:: toUser).collect(Collectors.toList());

        return ResponseEntity.ok()
                              .header(HttpHeaders.LINK, linkHeader.toString())
                              .body(users);

    }

    public  ResponseEntity<Void> blockUser(@ApiParam(value = "",required=true) @PathVariable("e_mail") String eMail)  {
            UserEntity userEntity = userRepository.findByEmail(eMail);
            userEntity.setStatus("block");
            userRepository.save(userEntity);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }


    public ResponseEntity<Void> unblockUser(@ApiParam(value = "",required=true) @PathVariable("e_mail") String eMail)  {
        UserEntity userEntity = userRepository.findByEmail(eMail);
        userEntity.setStatus("unblock");
        userRepository.save(userEntity);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);

    }

    public ResponseEntity<Void> deleteUser(@ApiParam(value = "",required=true) @PathVariable("e_mail") String eMail) {

        UserEntity userEntity = userRepository.findByEmail(eMail);
        userRepository.delete(userEntity);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    public ResponseEntity<User> updateUser(@ApiParam(value = "",required=true) @PathVariable("e_mail") String eMail,
                                           @ApiParam(value = "" ,required=true )  @Valid @RequestBody User user) {

        UserEntity userEntity = userRepository.findByEmail(eMail);
        userEntity.setEmail(user.getEmail());
        userEntity.setFirstname(user.getFirstname());
        userEntity.setLastname(user.getLastname());
        UserEntity saveUserEntity = userRepository.save(userEntity);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("{email}")
                .buildAndExpand(userEntity.getEmail()).toUri();

        return ResponseEntity.created(location).body(toUser(saveUserEntity));

    }


    public static String createLinkHeader(final String uri, final String rel, final int page, final int size) {
        return String.format("<%s?page=%d&pageSize=%d>; rel=\"%s\"", uri, page, size, rel);
    }




}