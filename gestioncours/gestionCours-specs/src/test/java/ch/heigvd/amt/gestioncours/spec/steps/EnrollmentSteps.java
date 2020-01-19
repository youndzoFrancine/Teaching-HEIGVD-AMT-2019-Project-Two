package ch.heigvd.amt.gestioncours.spec.steps;

import ch.heigvd.amt.gestioncours.ApiException;
import ch.heigvd.amt.gestioncours.ApiResponse;
import ch.heigvd.amt.gestioncours.api.DefaultApi;
import ch.heigvd.amt.gestioncours.dto.Enrollment;
import ch.heigvd.amt.gestioncours.dto.EnrollmentList;
import ch.heigvd.amt.gestioncours.dto.LaboList;
import ch.heigvd.amt.gestioncours.spec.helpers.Environment;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
//import sun.tools.jstat.Token;

import java.util.List;

import static org.junit.Assert.*;

public class EnrollmentSteps {
    private Environment environment;
    private DefaultApi api;

    Enrollment enrollment;
    EnrollmentList existingEnrollment;

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
        existingEnrollment = new ch.heigvd.amt.gestioncours.dto.EnrollmentList();
        existingEnrollment.subjectId(1L);
        existingEnrollment.setEmail("francine.youndzokengne@heig-vd.ch");
        existingEnrollment.setName("AMT");
    }

    @When("^I POST it to the /enrollments endpoint$")
    public void i_POST_it_to_the_enrollments_endpoint() throws Throwable {

            try {
                environment.setLastApiResponse(api.createEnrollmentWithHttpInfo(enrollment));
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

    @When("^I send a GET on the /enrollments endpoints$")
    public void i_send_a_GET_on_the_enrollments_endpoints() throws Throwable {
        try {
            environment.setLastApiResponse(api.getEnrollmentsWithHttpInfo(1,10));
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

    @Given("^there exists an enrollment to delete$")
    public void there_exists_an_enrollment_to_delete() throws Throwable {
        try {
            environment.setLastApiResponse(api.getEnrollmentsWithHttpInfo(1,10));
            environment.setLastApiCallThrewException(false);
            environment.setLastApiException(null);
            environment.setLastStatusCode(environment.getLastApiResponse().getStatusCode());
            List<EnrollmentList> enrollmentList = (List<EnrollmentList>)environment.getLastApiResponse().getData();
            assertTrue(enrollmentList.size() > 0);
            existingEnrollment = enrollmentList.get(0);
        } catch (ApiException e) {
            environment.setLastApiCallThrewException(true);
            environment.setLastApiResponse(null);
            environment.setLastApiException(e);
            environment.setLastStatusCode(environment.getLastApiException().getCode());
        }
    }
    @When("^I send a DELETE to the /enrollments endpoints$")
    public void i_send_a_DELETE_to_the_enrollments_endpoints() throws Throwable {
            try {
                environment.setLastApiResponse(api.deleteEnrollmentWithHttpInfo("AMT"));
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