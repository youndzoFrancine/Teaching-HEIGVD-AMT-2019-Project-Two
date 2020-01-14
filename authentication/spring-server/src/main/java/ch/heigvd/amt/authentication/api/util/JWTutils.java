package ch.heigvd.amt.authentication.api.util;
import ch.heigvd.amt.authentication.entities.UserEntity;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.exceptions.JWTCreationException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTutils {

    @Value("SCHEMA")
    private static String SCHEMA = "Bearer";
    @Value("ISSUER")
    private static String ISSUER;
    private static String SECRET_KEY = "Crescy";
    private static long validity=24*60*60*1000;
    private static JWTVerifier verifier;

    /**
     *
     * @param userentity : utilisateur pour qui le token sera genéré
     */
    public static String generateToken (UserEntity userentity){

        Date now = new Date();
        System.out.println(SECRET_KEY);
        Date val = new Date(now.getTime() + validity);
        Claims claims = Jwts.claims().setSubject(userentity.getEmail());
        claims.put("role", userentity.getRole());
        claims.put("isBocked", userentity.getBlocked());

        try {
            return Jwts.builder()
                    .setClaims(claims)
                    .setIssuedAt(now)
                    .setExpiration(val)
                    .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                    .compact();
        } catch (JWTCreationException e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     *
     * @param header : entete entiere
     * @return le token genéré
     */
    public static  String extractToken(String header){
        //si entete nul ou longueur du token inferieur à la taille de éa chaine de caractere Bearer
        if (header == null || header.length() < SCHEMA.length() + 1) {
            return null;
        }
        return header.substring(SCHEMA.length() + 1);
    }

    /**
     *
     * @param token : token a verifier
     * @return : booleen qui renseigne sur l'authenticité du token
     */
    public static boolean verifyToken(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException ignored) {
            ignored.printStackTrace();
        }
        return false;
    }

    /**
     *
     * @param token : token de l'utilisateur
     * @return : l'adresse mail du user, extraite du token
     */
    public static String getEmail(String token){
        String str = "role";
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getSubject();
    }

    /**
     *
     * @param token de l'utilisateur
     * @return : le role du user, extrait du token
     */
    public static String getRole(String token){
        return (String) Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().get("role");
    }

    /**
     *
     * @param token de l'utilisateur
     * @return : l'etat(bloqué ou non) du user, extrait du token
     */
    public static String getIsBlocked(String token){
        return (String) Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().get("isBocked");
    }

}
