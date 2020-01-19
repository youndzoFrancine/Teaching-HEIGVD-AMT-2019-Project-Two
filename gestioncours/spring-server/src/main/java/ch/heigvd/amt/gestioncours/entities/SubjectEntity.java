package ch.heigvd.amt.gestioncours.entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Crescence Yimnaing on 12/12/19.
 */
@Entity
public class SubjectEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private long credits_etcs;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private LaboEntity laboEntity;

    public long getId() { return id; }

    public void setLaboEntity(LaboEntity laboEntity) {
        this.laboEntity = laboEntity;
    }

    public LaboEntity getLaboEntity() {
        return laboEntity;
    }

    public String getName() { return name; }

    public void setId(long id) {
        this.id = id;
    }

    public long getCredits_etcs() { return credits_etcs; }

    public void setName(String name) { this.name = name; }

    public void setCredits_etcs(long credits_etcs) { this.credits_etcs = credits_etcs; }

}
