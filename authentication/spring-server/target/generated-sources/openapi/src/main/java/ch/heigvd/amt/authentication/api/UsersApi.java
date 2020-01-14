/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (4.2.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package ch.heigvd.amt.authentication.api;

import ch.heigvd.amt.authentication.api.model.User;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-01-14T15:21:16.587+01:00[Europe/Berlin]")

@Validated
@Api(value = "users", description = "the users API")
public interface UsersApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    @ApiOperation(value = "", nickname = "blockUser", notes = "the admin block a user", authorizations = {
        @Authorization(value = "bearerAuth")
    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "success"),
        @ApiResponse(code = 401, message = "Access token is missing or is invalid") })
    @RequestMapping(value = "/users/{e_mail}/block",
        method = RequestMethod.PATCH)
    default ResponseEntity<Void> blockUser(@ApiParam(value = "",required=true) @PathVariable("e_mail") String eMail) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    @ApiOperation(value = "", nickname = "createUser", notes = "create a user", response = User.class, authorizations = {
        @Authorization(value = "bearerAuth")
    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "created", response = User.class),
        @ApiResponse(code = 401, message = "Access token is missing or is invalid") })
    @RequestMapping(value = "/users",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    default ResponseEntity<User> createUser(@ApiParam(value = "" ,required=true )  @Valid @RequestBody User user) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"firstname\" : \"firstname\", \"password\" : \"password\", \"role\" : \"role\", \"isBlock\" : true, \"email\" : \"email\", \"lastname\" : \"lastname\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    @ApiOperation(value = "", nickname = "deleteUser", notes = "deletes a single user based on the e_mail supplied", authorizations = {
        @Authorization(value = "bearerAuth")
    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "success"),
        @ApiResponse(code = 401, message = "Access token is missing or is invalid") })
    @RequestMapping(value = "/users/{e_mail}",
        method = RequestMethod.DELETE)
    default ResponseEntity<Void> deleteUser(@ApiParam(value = "",required=true) @PathVariable("e_mail") String eMail) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    @ApiOperation(value = "", nickname = "getUsers", notes = "get the list of users", response = User.class, responseContainer = "List", authorizations = {
        @Authorization(value = "bearerAuth")
    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "success", response = User.class, responseContainer = "List") })
    @RequestMapping(value = "/users",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<List<User>> getUsers() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"firstname\" : \"firstname\", \"password\" : \"password\", \"role\" : \"role\", \"isBlock\" : true, \"email\" : \"email\", \"lastname\" : \"lastname\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    @ApiOperation(value = "", nickname = "unblockUser", notes = "the admin block a user", authorizations = {
        @Authorization(value = "bearerAuth")
    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "success"),
        @ApiResponse(code = 401, message = "Access token is missing or is invalid") })
    @RequestMapping(value = "/users/{e_mail}/unblock",
        method = RequestMethod.PATCH)
    default ResponseEntity<Void> unblockUser(@ApiParam(value = "",required=true) @PathVariable("e_mail") String eMail) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    @ApiOperation(value = "", nickname = "updateUser", notes = "updates a single user based on the e_mail supplied", response = User.class, authorizations = {
        @Authorization(value = "bearerAuth")
    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "success", response = User.class),
        @ApiResponse(code = 401, message = "Access token is missing or is invalid") })
    @RequestMapping(value = "/users/{e_mail}",
        produces = { "application/json" }, 
        method = RequestMethod.PUT)
    default ResponseEntity<User> updateUser(@ApiParam(value = "",required=true) @PathVariable("e_mail") String eMail) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"firstname\" : \"firstname\", \"password\" : \"password\", \"role\" : \"role\", \"isBlock\" : true, \"email\" : \"email\", \"lastname\" : \"lastname\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
