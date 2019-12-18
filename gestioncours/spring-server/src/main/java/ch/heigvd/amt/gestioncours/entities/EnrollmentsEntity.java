package ch.heigvd.amt.gestioncours.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class EnrollmentsEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String subject_name;
    private String student_email;

    public long getId() {
        return id;
    }

    public String getStudent_email() {
        return student_email;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setStudent_email(String student_email) {
        this.student_email = student_email;
    }
}
