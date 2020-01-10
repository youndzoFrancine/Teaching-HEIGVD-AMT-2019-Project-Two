package ch.heigvd.amt.authentication.entities;

import ch.heigvd.amt.authentication.api.util.PasswordUtile;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Crescence Yimnaing on 12/12/19.
 */

@Entity
public class UserEntity implements Serializable {
    
    @Id
    @Column(name = "email", nullable = false, unique= true)
    private String email;

    @Column(name = "firstname", nullable = false)
    private String firstname;

    @Column(name = "lastname", nullable = false)
    private String lastname;

    @Lob
    @Column(name = "password", nullable = false)
    private byte[] password;
    
    private String role;

    @Lob
    @Column(name = "salt", nullable = true)
    private byte[] salt;

    public byte[] getSalt() { return salt; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public void setRole(String role) { this.role = role; }

    public String getRole() { return role; }

    public String getFirstname() { return firstname; }

    public void setFirstname(String firstname) { this.firstname = firstname; }

    public String getLastname() { return lastname; }

    public void setLastname(String lastname) { this.lastname = lastname; }

    public byte[] getPassword() { return password; }

    public void setPassword(String password) {
        this.salt = PasswordUtile.generateSalt();
        this.password = PasswordUtile.hashPassword(password, salt);

    }

}
