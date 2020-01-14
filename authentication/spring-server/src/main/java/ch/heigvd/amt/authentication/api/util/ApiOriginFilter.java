package ch.heigvd.amt.authentication.api.util;

import ch.heigvd.amt.authentication.entities.UserEntity;
import ch.heigvd.amt.authentication.repositories.UserRepository;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-07-26T19:36:34.802Z")
@Component
public class ApiOriginFilter implements Filter {
    private static Logger LOG = Logger.getLogger(ApiOriginFilter.class.getName());

    UserRepository userRepository;

    @Autowired
    public ApiOriginFilter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //recuperation de l'url
        String uri = request.getRequestURI().substring(request.getContextPath().length());
        //recuperation du token
        String token = JWTutils.extractToken(request.getHeader("auth"));
        //urls de la documentation swagger utile pour les filtres
        boolean doc = uri.equals(URIs.DOCUMENTATION) ||
                uri.equals(URIs.SWAGGER_HTML) ||
                uri.startsWith(URIs.SWAGGER_UI_RESOURCES) ||
                uri.startsWith(URIs.SWAGGER_RESOURCES) ||
                uri.equals(URIs.V2_API_DOCS);

        // reseigne si l'url recuperée est une url pour l'authentification
        boolean authRequest = uri.equals(URIs.AUTH);
        // reseigne si l'url recuperée est une url pour bloqué ou debloqué les users
        boolean toBlock = uri.equals(URIs.BLOCK) || uri.equals(URIs.UNBLOCK);

        //url de documentation swagger ou d'authentification sans token eistant: on forward la requete
        if(doc || (authRequest && token==null)){
            chain.doFilter(servletRequest, response);
            return;
        }

        try {
            //verification du token
            boolean jwt = JWTutils.verifyToken(token);

            // if token is not valid
            if (!jwt) {
                //requete d'authentification: on forward
                if (authRequest) {
                    chain.doFilter(request, response);
                    return;
                }
                //jwt invalide et requete autre que l'authentification: erreur(token invalide)
                sendError(response, HttpServletResponse.SC_UNAUTHORIZED, ErrorsCodes.JWT_INVALID,
                        ErrorsCodes.JWT_INVALID_MESSAGE);
                return;
            }

            if (authRequest) {
                sendError(response, HttpServletResponse.SC_BAD_REQUEST, ErrorsCodes.ALREADY_AUTHENTICATED,
                        ErrorsCodes.ALREADY_AUTHENTICATED_MESSAGE);
                return;
            }

            //if a normal user try to have access to functions deserve to admin
            if((uri.equals(URIs.CREATE_USER) || toBlock) && !(JWTutils.getRole(token).equals("admin") )){
                sendError(response, HttpServletResponse.SC_BAD_REQUEST, ErrorsCodes.NOT_AUTHORIZED,
                        ErrorsCodes.NOT_AUTHORIZED_MESSAGE);
                return;
            }

            servletRequest.setAttribute("email", JWTutils.getEmail(token));
            servletRequest.setAttribute("role", JWTutils.getRole(token));
            servletRequest.setAttribute("isBlocked", JWTutils.getIsBlocked(token));
            chain.doFilter(request, response);

        } catch (JWTDecodeException exception) {
            LOG.log(Level.WARNING, "Invalid JWT format");
            sendError(response, HttpServletResponse.SC_UNAUTHORIZED, ErrorsCodes.INVALID_JWT_FORMAT,
                    ErrorsCodes.INVALID_JWT_FORMAT_MESSAGE);
        }
    }

    private void sendError(HttpServletResponse response, int status, String errorCode, String message) throws IOException {
        response.setStatus(status);
        response.setHeader("Content-Type", "application/json");

        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(new ErrorDescription(errorCode, message)));
    }
    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
}
