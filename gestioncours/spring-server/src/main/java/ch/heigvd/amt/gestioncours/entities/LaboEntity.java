package ch.heigvd.amt.gestioncours.entities;

/**
 * francine Youndzo
 */

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class LaboEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    private String laboName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private Integer ponderation;


    public String getLaboName() {
        return laboName;
    }

    public void setLaboName(String laboName) {
        this.laboName = laboName;
    }

    public Integer getPonderation() {
        return ponderation;
    }

    public void setPonderation(Integer ponderation) {
        this.ponderation = ponderation;
    }
}
