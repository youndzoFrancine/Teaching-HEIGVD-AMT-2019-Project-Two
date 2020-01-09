package ch.heigvd.amt.gestioncours.api.endpoints;

import ch.heigvd.amt.gestioncours.api.ApiUtil;
import ch.heigvd.amt.gestioncours.api.model.Enrollment;
import ch.heigvd.amt.gestioncours.api.model.Labo;
import ch.heigvd.amt.gestioncours.api.model.SubjectList;
import ch.heigvd.amt.gestioncours.entities.EnrollmentEntity;
import ch.heigvd.amt.gestioncours.entities.LaboEntity;
import ch.heigvd.amt.gestioncours.repositories.LaboRepository;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class LabosApiEntity {

    @Autowired
    LaboRepository labosRepository;

    public ResponseEntity<Void> createLabo(@ApiParam(value = "" ,required=true )  @Valid @RequestBody Labo labo) {
        LaboEntity newLaboEntity = toLaboEntity(labo);
        labosRepository.save(newLaboEntity);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(newLaboEntity.getLaboName()).toUri();

        return ResponseEntity.created(location).build();

    }
    public ResponseEntity<List<Labo>> getLabos() {
        List<Labo> labos = new ArrayList<>();
        for (LaboEntity laboEntity : labosRepository.findAll()) {
            labos.add(toLabo(laboEntity));
        }

        return ResponseEntity.ok(labos);
    }


    private LaboEntity toLaboEntity(Labo labo) {
        LaboEntity entity = new LaboEntity();
        entity.setLaboName(labo.getLaboName());
        entity.setPonderation(labo.getPonderation());
        return entity;
    }


    private Labo toLabo(LaboEntity entity) {
        Labo labo = new Labo();
        labo.setLaboName(entity.getLaboName());
        labo.setPonderation(entity.getPonderation());
        return labo;
    }
}
