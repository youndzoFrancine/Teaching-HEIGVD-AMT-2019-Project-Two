package ch.heigvd.amt.gestioncours.spec.steps;

import ch.heigvd.amt.gestioncours.ApiException;
import ch.heigvd.amt.gestioncours.ApiResponse;
import ch.heigvd.amt.gestioncours.api.DefaultApi;
import ch.heigvd.amt.gestioncours.dto.Subject;
import ch.heigvd.amt.gestioncours.spec.helpers.Environment;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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

    @Given("^I  GET an existing subject$")
    public void i_GET_an_existing_subject() throws Throwable {
        try {
            lastApiResponse = api.getSubjectsWithHttpInfo();
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

    @When("^I get a subject$")
    public void i_get_a_subject() throws Throwable {
        try {
            lastApiResponse = api.getSubjectsWithHttpInfo();
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


}
