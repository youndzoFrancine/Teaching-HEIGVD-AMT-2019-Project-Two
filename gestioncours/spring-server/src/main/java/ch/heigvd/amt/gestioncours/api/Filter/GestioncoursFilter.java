package ch.heigvd.amt.gestioncours.api.Filter;


import ch.heigvd.amt.gestioncours.api.errors.ErrorDescription;
import ch.heigvd.amt.gestioncours.api.errors.ErrorsCodes;
import ch.heigvd.amt.gestioncours.api.util.JWTutils;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class GestioncoursFilter implements Filter {

    private static Logger LOG = Logger.getLogger(GestioncoursFilter.class.getName());

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String uri = request.getRequestURI().substring(request.getContextPath().length());
        System.out.println(request.getHeader("authorization"));
        String token = JWTutils.extractToken(request.getHeader("authorization"));
        System.out.println(token);
        boolean doc = uri.equals(URIs.DOCUMENTATION) ||
                uri.equals(URIs.SWAGGER_HTML) ||
                uri.startsWith(URIs.SWAGGER_UI_RESOURCES) ||
                uri.startsWith(URIs.SWAGGER_RESOURCES) ||
                uri.equals(URIs.V2_API_DOCS) || uri.equals(URIs.CREATE_SUBJECT);

        boolean admin = uri.equals(URIs.CREATE_LABO)  /*|| uri.equals(URIs.CREATE_SUBJECT) */ ||
                uri.startsWith(URIs.UPDATE_LABO) || uri.startsWith(URIs.UPDATE_SUBJECT);

        if(doc){
            chain.doFilter(servletRequest, response);
            return;
        }

        try {
            boolean jwt = JWTutils.verifyToken(token);
            // if token is not valid
            if (!jwt) {
                sendError(response, HttpServletResponse.SC_UNAUTHORIZED, ErrorsCodes.JWT_INVALID,
                        ErrorsCodes.JWT_INVALID_MESSAGE);
                return;
            }

            //if a normal user try to have access to functions deserve to admin
            if( admin && !(JWTutils.getRole(token).equals("admin") )){
                sendError(response, HttpServletResponse.SC_BAD_REQUEST, ErrorsCodes.NOT_AUTHORIZED,
                        ErrorsCodes.NOT_AUTHORIZED_MESSAGE);
                return;
            }

            System.out.println("email  " + JWTutils.getEmail(token));
            System.out.println("role   " +JWTutils.getRole(token));

            servletRequest.setAttribute("email", JWTutils.getEmail(token));
            servletRequest.setAttribute("role", JWTutils.getRole(token));

            chain.doFilter(request, response);
        } catch (JWTDecodeException exception) {
            LOG.log(Level.WARNING, "Invalid JWT format");
            sendError(response, HttpServletResponse.SC_UNAUTHORIZED, ErrorsCodes.INVALID_JWT_FORMAT,
                    ErrorsCodes.INVALID_JWT_FORMAT_MESSAGE);
        }
    }

    private void sendError(HttpServletResponse response, int status, String errorCode, String message) throws
            IOException {
        response.setStatus(status);
        response.setHeader("Content-Type", "application/json");

        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(new ErrorDescription(errorCode, message)));
    }


}
