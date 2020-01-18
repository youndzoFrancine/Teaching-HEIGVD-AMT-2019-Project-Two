package ch.heigvd.amt.gestioncours.repositories;

import ch.heigvd.amt.gestioncours.api.model.Labo;
import ch.heigvd.amt.gestioncours.entities.LaboEntity;
import org.springframework.data.repository.CrudRepository;

public interface LaboRepository extends CrudRepository<LaboEntity, Long> {
}
