package ch.heigvd.amt.gestioncours.spec.steps;

import ch.heigvd.amt.gestioncours.ApiException;
import ch.heigvd.amt.gestioncours.ApiResponse;
import ch.heigvd.amt.gestioncours.api.DefaultApi;
import ch.heigvd.amt.gestioncours.dto.Enrollment;
import ch.heigvd.amt.gestioncours.dto.EnrollmentList;
import ch.heigvd.amt.gestioncours.spec.helpers.Environment;
import cucumber.runtime.CucumberException;
import org.apache.http.HttpStatus;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static org.junit.Assert.*;

public class EnrollmentSteps {
    private Environment environment;
    private DefaultApi api;

    Enrollment enrollment;
    EnrollmentList existingEnrollment;

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
        enrollment.setStudentEmail("olivier@heig-vd.ch");
        enrollment.setSubjectId(2L);
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

    @Then("^I receive a (\\d+) status code$")
    public void i_receive_a_status_code(int arg1) throws Throwable {
        assertEquals(arg1, lastStatusCode);
    }

    @Given("^there exists a enrollment$")
    public void there_exists_a_enrollment() throws Throwable {
        try {
            lastApiResponse = api.getEnrollmentsWithHttpInfo();
            lastApiCallThrewException = false;
            lastApiException = null;
            lastStatusCode = lastApiResponse.getStatusCode();
            List<EnrollmentList> enrollments = (List<EnrollmentList>)lastApiResponse.getData();
            assertTrue(enrollments.size() > 0);
            existingEnrollment = enrollments.get(0);
        } catch (ApiException e) {
            lastApiCallThrewException = true;
            lastApiResponse = null;
            lastApiException = e;
            lastStatusCode = lastApiException.getCode();
        }

    }

    @When("^I delete the enrollment$")
    public void i_delete_the_enrollment() throws Throwable {
        try {
            Integer enrollmentId = existingEnrollment.getId().intValue();
            lastApiResponse = api.deleteEnrollmentWithHttpInfo(enrollmentId);
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

    @Then("^I get a 'OK' response$")
    public void i_get_a_OK_response() throws Throwable {

    }



    @Given("^there exists an enrollment to update$")
    public void there_exists_an_enrollment_to_update() throws Throwable {
        try {
            lastApiResponse = api.getEnrollmentsWithHttpInfo();
            lastApiCallThrewException = false;
            lastApiException = null;
            lastStatusCode = lastApiResponse.getStatusCode();
            List<EnrollmentList> enrollments = (List<EnrollmentList>)lastApiResponse.getData();
            assertTrue(enrollments.size() > 0);
            existingEnrollment = enrollments.get(0);
        } catch (ApiException e) {
            lastApiCallThrewException = true;
            lastApiResponse = null;
            lastApiException = e;
            lastStatusCode = lastApiException.getCode();
        }
    }

    @When("^I update the enrollment$")
    public void i_update_the_enrollment() throws Throwable {
        try {
            Integer enrollmentId = existingEnrollment.getId().intValue();
            lastApiResponse = api.getEnrollmentsWithHttpInfo();
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

    @Then("^I receive a 'SUCCESS' response$")
    public void i_receive_a_SUCCESS_response() throws Throwable {

    }

}