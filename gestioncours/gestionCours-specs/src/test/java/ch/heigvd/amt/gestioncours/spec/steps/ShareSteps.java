package ch.heigvd.amt.gestioncours.spec.steps;

import ch.heigvd.amt.gestioncours.ApiException;
import ch.heigvd.amt.gestioncours.ApiResponse;
import ch.heigvd.amt.gestioncours.api.DefaultApi;
import ch.heigvd.amt.gestioncours.spec.helpers.Environment;
import cucumber.api.java.en.Then;

import static org.junit.Assert.assertEquals;

public class ShareSteps {
    private Environment environment;
    private DefaultApi api;

    public ShareSteps(Environment environment) {
        this.environment = environment;
        this.api = environment.getApi();
    }

    @Then("^I receive a (\\d+) status code$")
    public void i_receive_a_status_code(int expectedStatusCode) throws Throwable {
        if (environment.isLastApiCallThrewException()) {
            assertEquals(expectedStatusCode, environment.getLastApiException().getCode());
        } else {
            assertEquals(expectedStatusCode, environment.getLastApiResponse().getStatusCode());
        }    }
}
