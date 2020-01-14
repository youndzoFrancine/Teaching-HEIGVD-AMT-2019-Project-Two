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

    @Column(columnDefinition="tinyint(1) default 0")
    private Boolean blocked ;

    @Lob
    @Column(name = "salt", nullable = true)
    private byte[] salt;

    /**
     *
     * @return : un tableau de byte correspondant au sel
     */
    public byte[] getSalt() { return salt; }

    /**
     *
     * @return : un booleen qui renseigne si un utilisateur est bloqué ou non
     */
    public Boolean getBlocked() { return blocked; }

    /**
     *
     * @param blocked : booléen qui renseigne sur l'etat s'un utilisateur(bloqué ou non).
     */
    public void setBlocked(Boolean blocked) { this.blocked = blocked; }

    /**
     *
     * @return : l'adresse mail d'un utilisateur.
     */
    public String getEmail() { return email; }

    /**
     *
     * @param email : adresse à mettre à jour
     */
    public void setEmail(String email) { this.email = email; }

    /**
     *
     * @param role : role d'un utilisateur(admin ou normaluser)
     */
    public void setRole(String role) { this.role = role; }

    /**
     *
     * @return :
     */
    public String getRole() { return role; }

    /**
     *
     * @return : user firstname
     */
    public String getFirstname() { return firstname; }

    /**
     *
     * @param firstname : user firstname to set
     */
    public void setFirstname(String firstname) { this.firstname = firstname; }

    /**
     *
     * @return : the user lastname
     */
    public String getLastname() { return lastname; }

    /**
     *
     * @param lastname : user lastname to set
     */
    public void setLastname(String lastname) { this.lastname = lastname; }

    /**
     *
     * @return : tableau de byte retourné correspondant au mot de passe.
     */
    public byte[] getPassword() { return password; }

    /**
     * @Brief : crypte le mot de passe fourni
     * @param password : nouveau mot de passe de l'utilisateur.
     */
    public void setPassword(String password) {
        this.salt = PasswordUtile.generateSalt();
        this.password = PasswordUtile.hashPassword(password, salt);

    }

}
