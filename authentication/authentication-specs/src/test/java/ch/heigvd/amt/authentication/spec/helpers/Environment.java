package ch.heigvd.amt.authentication.spec.helpers;

import java.io.IOException;
import java.util.Properties;
import ch.heigvd.amt.authentication.ApiException;
import ch.heigvd.amt.authentication.api.DefaultApi;
import io.swagger.annotations.ApiResponse;
import lombok.Setter;
import lombok.Getter;

/**
 * Created by Olivier Liechti on 24/06/17.
 */
@Getter
@Setter
public class Environment {
    private ApiResponse lastApiResponse;
    private ApiException lastApiException;
    private boolean lastApiCallThrewException;
    private int lastStatusCode;
    private DefaultApi api = new DefaultApi();

    public Environment() throws IOException {
        Properties properties = new Properties();
        properties.load(this.getClass().getClassLoader().getResourceAsStream("environment.properties"));
        String url = properties.getProperty("ch.heigvd.amt.authentication.server.url");
        api.getApiClient().setBasePath(url);

    }

}

