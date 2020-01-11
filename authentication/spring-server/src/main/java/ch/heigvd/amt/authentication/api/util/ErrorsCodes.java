package ch.heigvd.amt.authentication.api.util;

public interface ErrorsCodes {
    String FIELD_REQUIRED = "0";
    String FIELD_REQUIRED_MESSAGE = "this field is required";

    String FIELD_EMPTY = "1";
    String FIELD_EMPTY_MESSAGE = "this field can not be empty";

    String MALFORMED_JSON = "2";
    String MALFORMED_JSON_MESSAGE = "malformed JSON";

    String FIELD_UNIQUE = "3";
    String FIELD_UNIQUE_MESSAGE = "this field must be unique";

    String USER_DOES_NOT_EXIST = "4";
    String USER_DOES_NOT_EXIST_MESSAGE = "user doesn't exist";


    String AUTHENTICATION_FAILED = "5";
    String AUTHENTICATION_FAILED_MESSAGE = "authentication failed";

    String ALREADY_AUTHENTICATED = "6";
    String ALREADY_AUTHENTICATED_MESSAGE = "already authenticated";

    String NO_TOKEN = "7";
    String NO_TOKEN_MESSAGE = "no token";

    String JWT_INVALID = "8";
    String JWT_INVALID_MESSAGE = "JWT is invalid";

    String INVALID_JWT_FORMAT = "9";
    String INVALID_JWT_FORMAT_MESSAGE = "invalid JWT format";

    String NOT_AUTHORIZED = "9";
    String NOT_AUTHORIZED_MESSAGE = "only admin can create user";

}
