package ch.heigvd.amt.gestioncours.api.endpoints;

import ch.heigvd.amt.gestioncours.api.LabosApi;
import ch.heigvd.amt.gestioncours.api.model.*;
import ch.heigvd.amt.gestioncours.entities.LaboEntity;
import ch.heigvd.amt.gestioncours.repositories.LaboRepository;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
public class LabosApiController implements LabosApi {

    @Autowired
    LaboRepository labosRepository;

    /**
     *
     * @param labo
     * @return
     */
    public ResponseEntity<Labo> createLabo(@ApiParam(value = "" ,required=true )  @Valid @RequestBody Labo labo) {
        LaboEntity newLaboEntity = toLaboEntity(labo); //convertir la dto en entité
        LaboEntity saveLaboEntity = labosRepository.save(newLaboEntity); //on persiste
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{laboName}")
                .buildAndExpand(saveLaboEntity.getLaboName()).toUri(); //on le stocke dans le header

        return ResponseEntity.created(location).body(toLabo(saveLaboEntity));

    }

    /**
     *
     * @param name
     * @return
     */
    public ResponseEntity<Void> deleteLabo(@ApiParam(value = "",required=true) @PathVariable("name") String name) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }
    /**
     *
     * @return
     */
    public ResponseEntity<List<Labo>> getLabos() {
        List<Labo> labos = new ArrayList<>();
        for (LaboEntity laboEntity : labosRepository.findAll()) {
            labos.add(toLabo(laboEntity));
        }
        return ResponseEntity.ok(labos);
    }

    /**
     *
     * @param laboName
     * @param labo
     * @return
     */
    public ResponseEntity<Labo> updateLabo(@ApiParam(value = "",required=true) @PathVariable("laboName") String laboName,@ApiParam(value = "" ,required=true )  @Valid @RequestBody Labo labo) {

        LaboEntity laboEntity = labosRepository.findByLaboName(laboName);
        LaboEntity saveLaboEntity = labosRepository.save(laboEntity); //on stocke l'objet persisté

       if(laboEntity != null){
            laboEntity.setLaboName(labo.getLaboName());
            laboEntity.setPonderation(labo.getPonderation());
        }

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(saveLaboEntity.getLaboName()).toUri();

        return ResponseEntity.created(location).body(toLabo(saveLaboEntity));

    }


    /**
     *
     * @param labo
     * @return
     */
    private LaboEntity toLaboEntity(Labo labo) {
        LaboEntity entity = new LaboEntity();
        entity.setLaboName(labo.getLaboName());
        entity.setPonderation(labo.getPonderation());
        return entity;
    }

    /**
     *
     * @param entity
     * @return
     */

    private Labo toLabo(LaboEntity entity) {
        Labo labo = new Labo();
        labo.setLaboName(entity.getLaboName());
        labo.setPonderation(entity.getPonderation());
        return labo;
    }

}
