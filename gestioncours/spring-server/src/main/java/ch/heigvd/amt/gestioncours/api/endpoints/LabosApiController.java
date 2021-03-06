package ch.heigvd.amt.gestioncours.api.endpoints;

import ch.heigvd.amt.gestioncours.api.LabosApi;
import ch.heigvd.amt.gestioncours.api.model.*;
import ch.heigvd.amt.gestioncours.entities.LaboEntity;
import ch.heigvd.amt.gestioncours.entities.SubjectEntity;
import ch.heigvd.amt.gestioncours.repositories.LaboRepository;
import ch.heigvd.amt.gestioncours.repositories.SubjectRepository;
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

    @Autowired
    SubjectRepository subjectRepository;

    /**
     *
     * @param labo
     * @return
     */
    public ResponseEntity<Labo> createLabo(@ApiParam(value = "" ,required=true )  @Valid @RequestBody Labo labo) {
        
      SubjectEntity subjectEntity = subjectRepository.findByName(labo.getSubjectName());

          if(subjectEntity!=null){

              LaboEntity newLaboEntity = toLaboEntity(labo); //convertir la dto en entité
              LaboEntity saveLaboEntity = labosRepository.save(newLaboEntity); //on persiste
              subjectEntity.setLaboEntity(newLaboEntity);
             subjectRepository.save(subjectEntity);
              Labo labo1 = toLabo(saveLaboEntity); 
              URI location = ServletUriComponentsBuilder
                      .fromCurrentRequest().path("/{id}")
                      .buildAndExpand(saveLaboEntity.getId()).toUri(); //on le stocke dans le header

              return ResponseEntity.created(location).body(labo1);

          }

      return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    /**
     *
     * @param id
     * @return
     */
    public ResponseEntity<Void> deleteLabo(@ApiParam(value = "",required=true) @PathVariable("id") Integer id) {
        LaboEntity laboEntity = labosRepository.findById(id.longValue());
        if (laboEntity != null) {
            labosRepository.delete(laboEntity);
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

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

    public ResponseEntity<Labo> getLaboById(@ApiParam(value = "ID of labo to fetch",required=true) @PathVariable("id") Integer id){

        LaboEntity laboEntity = labosRepository.findById(id.longValue());

        if(laboEntity!= null){
            return ResponseEntity.ok(toLabo(laboEntity));
        }

        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    /**
     *
     * @param id
     * @param labo
     * @return
     */
    public ResponseEntity<Labo> updateLabo(@ApiParam(value = "",required=true) @PathVariable("id") Integer id,
                                           @ApiParam(value = "" ,required=true )  @Valid @RequestBody Labo labo) {

        LaboEntity laboEntity = labosRepository.findById(id.longValue());

        if(laboEntity != null){//recupere l'objet aavnt de mettre à jour
            laboEntity.setLaboName(labo.getLaboName());
            laboEntity.setPonderation(labo.getPonderation());
        }
        LaboEntity saveLaboEntity = labosRepository.save(laboEntity); //on stocke l'objet persisté

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(saveLaboEntity.getId()).toUri();

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
        labo.setId(entity.getId());
        labo.setLaboName(entity.getLaboName());
        labo.setPonderation(entity.getPonderation());
        if(subjectRepository.findByLaboEntity(entity)!=null)
        labo.setSubjectName(subjectRepository.findByLaboEntity(entity).getName());
        return labo;
    }

}
