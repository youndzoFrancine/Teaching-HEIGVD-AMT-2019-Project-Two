package ch.heigvd.amt.authentication.api.filter;

public interface URIs {

    String AUTH = "/login";
    String SWAGGER_HTML = "/swagger-ui.html";
    String SWAGGER_UI_RESOURCES = "/webjars/springfox-swagger-ui/";
    String SWAGGER_RESOURCES = "/swagger-resources";
    String V2_API_DOCS = "/api-docs";
    String DOCUMENTATION = "/";
    String CREATE_USER = "/register";
    String GET_USERS = "/users";
    String BLOCK = "/users/block/";
    String UNBLOCK = "/users/unblock/";
    String FORGOT_PASSWORD = "/reset_password";
    String RESET_PASSWORD = "/update_password";

}
