package ch.heigvd.amt.gestioncours.api.util;

import com.auth0.jwt.JWTVerifier;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JWTutils {
    //private static final Logger LOG = Logger.getLogger(JWTUtils.class.getName());

    @Value("SCHEMA")
    private static String SCHEMA = "Bearer";
    @Value("ISSUER")
    private static String ISSUER;
    private static String SECRET_KEY = "crescy";
    private static long validity=24*60*60*1000;
    private static JWTVerifier verifier;

    public static  String extractToken(String header){
        if (header == null || header.length() < SCHEMA.length() + 1) {
            return null;
        }

        return header.substring(SCHEMA.length() + 1);
    }
    public static boolean verifyToken(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException ignored) {
        }
        return false;
    }

    public static String getEmail(String token){
        String str = "role";
        return (String) Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().get("role");
    }

    public static String getRole(String token){
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getSubject();
    }

}
