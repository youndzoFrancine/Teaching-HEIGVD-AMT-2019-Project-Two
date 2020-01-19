package ch.heigvd.amt.authentication.api.endpoints;

import ch.heigvd.amt.authentication.api.UsersApi;
import ch.heigvd.amt.authentication.api.exceptions.UserDoesNotExistException;
import ch.heigvd.amt.authentication.api.model.User;
import ch.heigvd.amt.authentication.api.model.UserMin;
import ch.heigvd.amt.authentication.api.util.UserUtils;
import ch.heigvd.amt.authentication.entities.UserEntity;
import ch.heigvd.amt.authentication.repositories.UserRepository;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UsersApiController implements UsersApi {



    @Autowired
    UserRepository userRepository;
    @Autowired
    HttpServletRequest httpServletRequest;


    public ResponseEntity<List<UserMin>> getUsers(@ApiParam(value = "Page number", defaultValue = "1") @Valid @RequestParam(value = "page",
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


         List<UserMin> users = userRepository.findAll(PageRequest.of(page -1, pageSize)).parallelStream().
                 map(UserUtils::toUserMin).collect(Collectors.toList());

        return ResponseEntity.ok()
                              .header(HttpHeaders.LINK, linkHeader.toString())
                              .body(users);

    }

    public  ResponseEntity<Void> blockUser(@ApiParam(value = "",required=true) @PathVariable("e_mail") String eMail)  {
            UserEntity userEntity = userRepository.findByEmail(eMail);
            userEntity.setStatus("block");
            userRepository.save(userEntity);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    public ResponseEntity<Void> unblockUser(@ApiParam(value = "",required=true) @PathVariable("e_mail") String eMail)  {
        UserEntity userEntity = userRepository.findByEmail(eMail);
        userEntity.setStatus("unblock");
        userRepository.save(userEntity);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    public ResponseEntity<Void> deleteUser(@ApiParam(value = "",required=true) @PathVariable("e_mail") String eMail) {

        UserEntity userEntity = userRepository.findByEmail(eMail);
        userRepository.delete(userEntity);
        return new ResponseEntity<>(HttpStatus.OK);
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

        return ResponseEntity.created(location).body(UserUtils.toUser(saveUserEntity));

    }
   public  ResponseEntity<UserMin> updateUser(@ApiParam(value = "",required=true) @PathVariable("e_mail") String eMail,@ApiParam(value = "" ,required=true )  @Valid @RequestBody UserMin userMin) {

        UserEntity user = userRepository.findByEmail(eMail);

        if(user != null){

            if(userMin.getFirstname() != null && !userMin.getFirstname().equals(user.getFirstname())){

                user.setFirstname(userMin.getFirstname());
            }

            if(userMin.getLastname() != null && !userMin.getLastname().equals(user.getLastname())){

                user.setLastname(userMin.getLastname());
            }

            if(userMin.getRole() != null && !userMin.getRole().equals(user.getRole())){

                user.setRole(userMin.getRole());
            }
            userRepository.save(user);

            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest().path("{email}")
                    .buildAndExpand(user.getEmail()).toUri();

            return ResponseEntity.created(location).body(UserUtils.toUserMin(user));
        }
        throw new UserDoesNotExistException();
    }

    public static String createLinkHeader(final String uri, final String rel, final int page, final int size) {
        return String.format("<%s?page=%d&pageSize=%d>; rel=\"%s\"", uri, page, size, rel);
    }




}