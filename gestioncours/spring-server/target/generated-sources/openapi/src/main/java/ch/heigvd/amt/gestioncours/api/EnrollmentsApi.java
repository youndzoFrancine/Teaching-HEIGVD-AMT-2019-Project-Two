/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (4.2.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package ch.heigvd.amt.gestioncours.api;

import ch.heigvd.amt.gestioncours.api.model.Enrollment;
import ch.heigvd.amt.gestioncours.api.model.EnrollmentList;
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
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-01-09T14:49:11.383+01:00[Europe/Zurich]")

@Validated
@Api(value = "enrollments", description = "the enrollments API")
public interface EnrollmentsApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    @ApiOperation(value = "", nickname = "createEnrollment", notes = "create an Enrollment", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "created"),
        @ApiResponse(code = 401, message = "unexpected error"),
        @ApiResponse(code = 403, message = "forbidden"),
        @ApiResponse(code = 404, message = "not found") })
    @RequestMapping(value = "/enrollments",
        consumes = { "application/json" },
        method = RequestMethod.POST)
    default ResponseEntity<Void> createEnrollment(@ApiParam(value = "" ,required=true )  @Valid @RequestBody Enrollment enrollment) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    @ApiOperation(value = "", nickname = "deleteEnrollment", notes = "delete a single enrollment on the ID supplied", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "enrollment deleted"),
        @ApiResponse(code = 200, message = "unexpected error") })
    @RequestMapping(value = "/enrollments/{id}",
        method = RequestMethod.DELETE)
    default ResponseEntity<Void> deleteEnrollment(@ApiParam(value = "",required=true) @PathVariable("id") Integer id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    @ApiOperation(value = "", nickname = "getEnrollmentById", notes = "Returns an enrollment based on a single ID", response = Enrollment.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "enrollment response", response = Enrollment.class),
        @ApiResponse(code = 200, message = "unexpected error") })
    @RequestMapping(value = "/enrollments/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<Enrollment> getEnrollmentById(@ApiParam(value = "ID of enrollment to fetch",required=true) @PathVariable("id") Integer id) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"subject_id\" : 0, \"user_email\" : \"user_email\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    @ApiOperation(value = "", nickname = "getEnrollments", notes = "get the list of all enrollments", response = EnrollmentList.class, responseContainer = "List", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "success", response = EnrollmentList.class, responseContainer = "List"),
        @ApiResponse(code = 401, message = "unexpected error") })
    @RequestMapping(value = "/enrollments",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<List<EnrollmentList>> getEnrollments() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "null";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
