package ch.heigvd.amt.gestioncours.spec.steps;

import ch.heigvd.amt.gestioncours.spec.helpers.Environment;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ch.heigvd.amt.gestioncours.ApiException;
import ch.heigvd.amt.gestioncours.ApiResponse;
import ch.heigvd.amt.gestioncours.api.DefaultApi;
import ch.heigvd.amt.gestioncours.dto.Subject;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

/**
 * Created by Olivier Liechti on 27/07/17.
 */
public class SubjectSteps {

    private Environment environment;
    private DefaultApi api;

    Subject subject;

    private ApiResponse lastApiResponse;
    private ApiException lastApiException;
    private boolean lastApiCallThrewException;
    private int lastStatusCode;

    public SubjectSteps(Environment environment) {
        this.environment = environment;
        this.api = environment.getApi();
    }

    @Given("^there is a Subjects server$")
    public void there_is_a_Subjects_server() throws Throwable {
        assertNotNull(api);
    }

    @Given("^I have a subject payload$")
    public void i_have_a_subject_payload() throws Throwable {
        subject = new ch.heigvd.amt.gestioncours.dto.Subject();
    }

    @When("^I POST it to the /subjects endpoint$")
    public void i_POST_it_to_the_subjects_endpoint() throws Throwable {
        try {
            lastApiResponse = api.createSubjectWithHttpInfo(subject);
            lastApiCallThrewException = false;
            lastApiException = null;
            lastStatusCode = lastApiResponse.getStatusCode();
        } catch (ApiException e) {
            lastApiCallThrewException = true;
            lastApiResponse = null;
            lastApiException = e;
            lastStatusCode = lastApiException.getCode();
        }
    }

    @Then("^I receive a (\\d+) status code$")
    public void i_receive_a_status_code(int arg1) throws Throwable {
        assertEquals(201, lastStatusCode);
    }

}
