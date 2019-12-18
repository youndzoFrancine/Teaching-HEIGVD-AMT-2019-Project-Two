package ch.heigvd.amt.gestioncours.api.endpoints;

import ch.heigvd.amt.gestioncours.api.model.Subject;
import ch.heigvd.amt.gestioncours.api.SubjectsApi;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class SubjectsApiController implements SubjectsApi {

    public ResponseEntity<Void> createSubject(@ApiParam(value = "" ,required=true )  @Valid @RequestBody Subject subject) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


}
