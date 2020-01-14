package ch.heigvd.amt.gestioncours.api.util;

public interface ErrorsCodes {
    String FIELD_REQUIRED = "0";
    String FIELD_REQUIRED_MESSAGE = "this field is required";

    String FIELD_EMPTY = "1";
    String FIELD_EMPTY_MESSAGE = "this field can not be empty";

    String MALFORMED_JSON = "2";
    String MALFORMED_JSON_MESSAGE = "malformed JSON";

    String FIELD_UNIQUE = "3";
    String FIELD_UNIQUE_MESSAGE = "this field must be unique";

    String NO_TOKEN = "4";
    String NO_TOKEN_MESSAGE = "no token";

    String JWT_INVALID = "5";
    String JWT_INVALID_MESSAGE = "JWT is invalid";

    String INVALID_JWT_FORMAT = "6";
    String INVALID_JWT_FORMAT_MESSAGE = "invalid JWT format";

}
