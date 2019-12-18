package ch.heigvd.amt.gestioncours.spec.steps;

import ch.heigvd.amt.gestioncours.ApiException;
import ch.heigvd.amt.gestioncours.ApiResponse;
import ch.heigvd.amt.gestioncours.api.DefaultApi;
import ch.heigvd.amt.gestioncours.dto.Enrollment;
import ch.heigvd.amt.gestioncours.spec.helpers.Environment;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertNotNull;

public class EnrollmentSteps {

    private Environment environment;
    private DefaultApi api;

    Enrollment enrollment;

    private ApiResponse lastApiResponse;
    private ApiException lastApiException;
    private boolean lastApiCallThrewException;
    private int lastStatusCode;

    public EnrollmentSteps(Environment environment) {
        this.environment = environment;
        this.api = environment.getApi();
    }
    @Given("^there is a Enrollments server$")
    public void there_is_a_Enrollments_server() throws Throwable {
        assertNotNull(api);
    }

    @Given("^I have a enrollment payload$")
    public void i_have_a_enrollment_payload() throws Throwable {

        enrollment = new ch.heigvd.amt.gestioncours.dto.Enrollment();
    }

    @When("^I POST it to the /enrollments endpoint$")
    public void i_POST_it_to_the_enrollments_endpoint() throws Throwable {
        try {
            lastApiResponse = api.createEnrollmentWithHttpInfo(enrollment);
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
