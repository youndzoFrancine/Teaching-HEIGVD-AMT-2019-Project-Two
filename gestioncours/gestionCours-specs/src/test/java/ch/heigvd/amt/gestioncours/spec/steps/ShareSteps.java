package ch.heigvd.amt.gestioncours.spec.steps;

import ch.heigvd.amt.gestioncours.ApiException;
import ch.heigvd.amt.gestioncours.ApiResponse;
import ch.heigvd.amt.gestioncours.api.DefaultApi;
import ch.heigvd.amt.gestioncours.spec.helpers.Environment;

public class ShareSteps {
    private Environment environment;
    private DefaultApi api;

    public ShareSteps(Environment environment) {
        this.environment = environment;
        this.api = environment.getApi();
    }
}
