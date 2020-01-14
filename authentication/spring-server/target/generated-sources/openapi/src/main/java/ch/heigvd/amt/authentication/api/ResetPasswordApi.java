/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (4.2.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package ch.heigvd.amt.authentication.api;

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
@Api(value = "reset_password", description = "the reset_password API")
public interface ResetPasswordApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    @ApiOperation(value = "", nickname = "forgotPassword", notes = "have access to ressources", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "update"),
        @ApiResponse(code = 401, message = "Access token is missing or is invalid") })
    @RequestMapping(value = "/reset_password",
        consumes = { "application/json" },
        method = RequestMethod.POST)
    default ResponseEntity<Void> forgotPassword(@ApiParam(value = ""  )  @Valid @RequestBody String body) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
