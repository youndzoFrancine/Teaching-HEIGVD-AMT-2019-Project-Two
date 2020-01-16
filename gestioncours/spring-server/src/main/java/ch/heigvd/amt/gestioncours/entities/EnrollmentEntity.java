package ch.heigvd.amt.gestioncours.entities;

/**
 * francine youndzo
 */

import jdk.nashorn.internal.objects.annotations.Getter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class EnrollmentEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private SubjectEntity subject;

    private String email;

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public SubjectEntity getSubject() {
        return subject;
    }

    public void setSubject(SubjectEntity subject) {
        this.subject = subject;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
