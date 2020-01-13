package ch.heigvd.amt.gestioncours.entities;

/**
 * francine youndzo
 */

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class EnrollmentEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private SubjectEntity subject;

    private String user_email;

    public long getId() {
        return id;
    }

    public String getUser_email() {
        return user_email;
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

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }
}
