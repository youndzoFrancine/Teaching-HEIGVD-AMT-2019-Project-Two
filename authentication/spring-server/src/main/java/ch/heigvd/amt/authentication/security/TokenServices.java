package ch.heigvd.amt.authentication.security;

import ch.heigvd.amt.authentication.api.model.Credentials;
import ch.heigvd.amt.authentication.api.model.Token;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

public class TokenServices {

    public Token createToken(Credentials credentials){
        Token token = null;
        try {
            Algorithm algorithm = Algorithm.HMAC256("amtprojet2");
            token.setToken(JWT.create()
                    .withIssuer("Crescy")
                    .withSubject(credentials.getEmail())
                    .sign(algorithm));

        } catch (JWTCreationException exception){
            //Invalid Signing configuration / Couldn't convert Claims.
        }
        return token;
    }

    public boolean verifyToken(Token token){
        String tokenStr = token.getToken();
        boolean tokenIsVerify = false;
        try {
            Algorithm algorithm = Algorithm.HMAC256("secret");
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("auth0")
                    .build(); //Reusable verifier instance
            DecodedJWT jwt = verifier.verify(tokenStr);
            tokenIsVerify = true;
        } catch (JWTVerificationException exception){
           // throw new JWTVerificationException (exception);
        }
        return tokenIsVerify;
    }

    public boolean decodeToken(Token token) {
        try {
            DecodedJWT jwt = JWT.decode(token.getToken());
        } catch (JWTDecodeException exception) {
            //Invalid token
        }
        return true;
    }
}
