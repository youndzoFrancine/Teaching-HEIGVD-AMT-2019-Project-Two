package ch.heigvd.amt.gestioncours.entities;

/**
 * francine Youndzo
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class LaboEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String laboName;
    private Long ponderation;

    public String getLaboName() {
        return laboName;
    }

    public void setLaboName(String laboName) {
        this.laboName = laboName;
    }

    public Long getPonderation() {
        return ponderation;
    }

    public void setPonderation(Long ponderation) {
        this.ponderation = ponderation;
    }
}
