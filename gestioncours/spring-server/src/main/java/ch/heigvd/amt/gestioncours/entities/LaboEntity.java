package ch.heigvd.amt.gestioncours.entities;

/**
 * francine Youndzo
 */

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class LaboEntity implements Serializable {

    @Id
    @Column(name= "laboName", unique= true, nullable=false)
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
