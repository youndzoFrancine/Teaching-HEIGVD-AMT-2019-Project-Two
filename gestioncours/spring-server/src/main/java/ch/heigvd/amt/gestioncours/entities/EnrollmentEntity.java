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

<<<<<<< HEAD
    private String student_email;
=======
    private String user_email;
>>>>>>> 63dd7b6021b3903ddab9bf1535649138ff826dc5

    public long getId() {
        return id;
    }

<<<<<<< HEAD
    public String getStudent_email() {
        return student_email;
=======
    public String getUser_email() {
        return user_email;
>>>>>>> 63dd7b6021b3903ddab9bf1535649138ff826dc5
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

<<<<<<< HEAD
    public void setStudent_email(String student_email) {
        this.student_email = student_email;
=======
    public void setUser_email(String user_email) {
        this.user_email = user_email;
>>>>>>> 63dd7b6021b3903ddab9bf1535649138ff826dc5
    }
}
