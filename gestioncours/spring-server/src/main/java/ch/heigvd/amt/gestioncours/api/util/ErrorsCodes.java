package ch.heigvd.amt.gestioncours.api.util;

public interface ErrorsCodes {

    String JWT_INVALID = "1";
    String JWT_INVALID_MESSAGE = "JWT is invalid";

    String INVALID_JWT_FORMAT = "2";
    String INVALID_JWT_FORMAT_MESSAGE = "invalid JWT format";

    String NOT_AUTHORIZED = "3";
    String NOT_AUTHORIZED_MESSAGE = "allow only to admins";

}
