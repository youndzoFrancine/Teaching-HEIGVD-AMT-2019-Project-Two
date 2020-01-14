package ch.heigvd.amt.gestioncours.spec.steps;

import ch.heigvd.amt.gestioncours.ApiException;
import ch.heigvd.amt.gestioncours.ApiResponse;
import ch.heigvd.amt.gestioncours.api.DefaultApi;
import ch.heigvd.amt.gestioncours.dto.Enrollment;
import ch.heigvd.amt.gestioncours.dto.EnrollmentList;
import ch.heigvd.amt.gestioncours.dto.Labo;
import ch.heigvd.amt.gestioncours.spec.helpers.Environment;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LaboSteps {

    private Environment environment;
    private DefaultApi api;

    Labo labo;

    EnrollmentList existingEnrollment;



    public LaboSteps(Environment environment) {
        this.environment = environment;
        this.api = environment.getApi();
    }

    @Given("^I have a labo payload$")
    public void i_have_a_labo_payload() throws Throwable {
        labo = new ch.heigvd.amt.gestioncours.dto.Labo();
        labo.setLaboName("Docker");
        labo.setPonderation(4L);
    }

    @When("^I POST it to the /labos endpoint$")
    public void i_POST_it_to_the_labos_endpoint() throws Throwable {
        try {
            environment.setLastApiResponse(api.createLaboWithHttpInfo(labo));
            environment.setLastApiCallThrewException(false);
            environment.setLastApiException(null);
            environment.setLastStatusCode(environment.getLastApiResponse().getStatusCode());
        } catch (ApiException e) {
            environment.setLastApiCallThrewException(true);
            environment.setLastApiException(null);
            environment.setLastApiException(e);
            environment.setLastStatusCode(environment.getLastApiException().getCode());
        }
    }

    @Given("^I  GET an existing labo$")
    public void i_GET_an_existing_labo() throws Throwable {

    }

    @When("^I get a labo$")
    public void i_get_a_labo() throws Throwable {

    }

    @Then("^I receive  (\\d+) status code$")
    public void i_receive_status_code(int arg1) throws Throwable {

    }

    @Given("^there exists an labo to delete$")
    public void there_exists_an_labo_to_delete() throws Throwable {

    }

    @When("^I DELETE the labo$")
    public void i_DELETE_the_labo() throws Throwable {

    }

    @Then("^I receive valid HTTP response code (\\d+) for \"([^\"]*)\"$")
    public void i_receive_valid_HTTP_response_code_for(int arg1, String arg2) throws Throwable {

    }

    @Given("^there exists an labo to update$")
    public void there_exists_an_labo_to_update() throws Throwable {

    }

    @When("^I UPDATE the labo$")
    public void i_UPDATE_the_labo() throws Throwable {

    }
}
