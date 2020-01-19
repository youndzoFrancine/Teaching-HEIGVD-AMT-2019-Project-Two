package ch.heigvd.amt.gestioncours.spec.steps;

import ch.heigvd.amt.gestioncours.ApiException;
import ch.heigvd.amt.gestioncours.ApiResponse;
import ch.heigvd.amt.gestioncours.api.DefaultApi;
import ch.heigvd.amt.gestioncours.dto.*;
import ch.heigvd.amt.gestioncours.spec.helpers.Environment;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class LaboSteps {

    private Environment environment;
    private DefaultApi api;

    Labo labo;
    LaboList existingLabo;


    public LaboSteps(Environment environment) {
        this.environment = environment;
        this.api = environment.getApi();
    }

    @Given("^there is a Labos server$")
    public void there_is_a_Labos_server() throws Throwable {
        assertNotNull(api);
    }

    @Given("^I have a labo  payload$")
    public void i_have_a_labo_payload() throws Throwable {
        labo = new ch.heigvd.amt.gestioncours.dto.Labo();
        labo.setLaboName("Docker");
        labo.setPonderation(4);
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
            environment.setLastApiResponse(null);
            environment.setLastApiException(e);
            environment.setLastStatusCode(environment.getLastApiException().getCode());
        }
    }

    @Given("^I  get an existing labo$")
    public void i_get_an_existing_labo() throws Throwable {
        try {

            environment.setLastApiResponse(api.getLabosWithHttpInfo());
            environment.setLastApiCallThrewException(false);
            environment.setLastApiException(null);
            environment.setLastStatusCode(environment.getLastApiResponse().getStatusCode());
        } catch (ApiException e) {
            environment.setLastApiCallThrewException(true);
            environment.setLastApiResponse(null);
            environment.setLastApiException(e);
            environment.setLastStatusCode(environment.getLastApiException().getCode());
        }
    }
    @When("^I send a GET to the /labos endpoints$")
    public void i_send_a_GET_to_the_labos_endpoints() throws Throwable {
        try {
            environment.setLastApiResponse(api.getLabosWithHttpInfo());
            environment.setLastApiCallThrewException(false);
            environment.setLastApiException(null);
            environment.setLastStatusCode(environment.getLastApiResponse().getStatusCode());
        } catch (ApiException e) {
            environment.setLastApiCallThrewException(true);
            environment.setLastApiResponse(null);
            environment.setLastApiException(e);
            environment.setLastStatusCode(environment.getLastApiException().getCode());
        }
    }


    @Given("^there exists a labo to delete$")
    public void there_exists_a_labo_to_delete() throws Throwable {
        try {
            environment.setLastApiResponse(api.getLabosWithHttpInfo());
            environment.setLastApiCallThrewException(false);
            environment.setLastApiException(null);
            environment.setLastStatusCode(environment.getLastApiResponse().getStatusCode());
            List<LaboList> laboLists = (List<LaboList>)environment.getLastApiResponse().getData();
            assertTrue(laboLists.size() > 0);
            existingLabo = laboLists.get(0);
        } catch (ApiException e) {
            environment.setLastApiCallThrewException(true);
            environment.setLastApiResponse(null);
            environment.setLastApiException(e);
            environment.setLastStatusCode(environment.getLastApiException().getCode());
        }
    }

    @When("^I send a DELETE to the /labos endpoints$")
    public void i_send_a_DELETE_to_the_labos_endpoint() throws Throwable {
        try {
            labo = new ch.heigvd.amt.gestioncours.dto.Labo();
            labo.setLaboName("Labo1");
            labo.setPonderation(10);
            Integer laboId = labo.getId().intValue();
            environment.setLastApiResponse(api.deleteLaboWithHttpInfo(laboId));
            environment.setLastApiCallThrewException(false);
            environment.setLastApiException(null);
            environment.setLastStatusCode(environment.getLastApiResponse().getStatusCode());
        } catch (ApiException e) {
            environment.setLastApiCallThrewException(true);
            environment.setLastApiResponse(null);
            environment.setLastApiException(e);
            environment.setLastStatusCode(environment.getLastApiException().getCode());
        }
    }

    @When("^I send a UPDATE to the /labos endpoint$")
    public void i_send_a_UPDATE_to_the_labos_endpoint() throws Throwable {
        try {
            labo = new ch.heigvd.amt.gestioncours.dto.Labo();
            labo.setLaboName("Labo1");
            labo.setPonderation(10);
            environment.setLastApiResponse(api.updateLaboWithHttpInfo(1,labo ));
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


}
