package ch.heigvd.amt.authentication.api.util;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Random;

/**
 *  useful functions to set user password
 */
public class PasswordUtile {

    //variables
    public static final int SALT_LENGTH = 32;
    public static final int N_ITERATIONS = 5000;
    public static final int KEY_LENGTH = 256;
    public static final String HASHING_ALGORITHM = "PBKDF2WithHmacSHA512";
    private static final Random random = new SecureRandom();

    /**
     *
     * @return
     */
    public static byte[] generateSalt() {
        byte[] salt = new byte[SALT_LENGTH];
        random.nextBytes(salt);
        return salt;
    }

    /**
     * @Brief : check si le password est valid ou pas
     * @param password : mot de passe en clair
     * @param storedPassword : mot de passe crypté
     * @param storedSalt : le sel generé et stocké
     * @return : un booléen qui est le résultat de la comparaison
     */
    public static boolean isPasswordValid(String password, byte[] storedPassword, byte[] storedSalt) {
        return Arrays.equals(hashPassword(password, storedSalt), storedPassword);
    }

    /**
     * @Brief : function qui crypte le mot de passe
     * @param password : mot de passe en clair
     * @param salt : le sel utilisé pour crypter le mot de passe
     * @return : un tableau de byte correspondant au mdp crypté
     */
    public static byte[] hashPassword(String password, byte[] salt) {
        try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance(HASHING_ALGORITHM);
            PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, N_ITERATIONS, KEY_LENGTH);
            SecretKey key = skf.generateSecret(spec);
            return key.getEncoded();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }

}
