package ch.heigvd.amt.authentication.api.util;

public interface URIs {
    String AUTH = "/authneticate";
    String SWAGGER_HTML = "/swagger-ui.html";
    String SWAGGER_UI_RESOURCES = "/webjars/springfox-swagger-ui/";
    String SWAGGER_RESOURCES = "/swagger-resources";
    String V2_API_DOCS = "/api-docs";
    String DOCUMENTATION = "/";
    String CREATE_USER = "/users";
    String BLOCK = "/users/{e_mail}/block";
    String UNBLOCK = "/users/{e_mail}/unblock";
}
