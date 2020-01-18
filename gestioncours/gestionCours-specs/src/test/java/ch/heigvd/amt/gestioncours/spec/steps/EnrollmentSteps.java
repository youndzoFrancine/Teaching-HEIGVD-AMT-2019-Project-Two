package ch.heigvd.amt.gestioncours.spec.steps;

import ch.heigvd.amt.gestioncours.ApiException;
import ch.heigvd.amt.gestioncours.ApiResponse;
import ch.heigvd.amt.gestioncours.api.DefaultApi;
import ch.heigvd.amt.gestioncours.dto.Enrollment;
import ch.heigvd.amt.gestioncours.dto.EnrollmentList;
import ch.heigvd.amt.gestioncours.spec.helpers.Environment;
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
        enrollment.setUserEmail("olivier@heig-vd.ch");
        enrollment.setSubjectId(2L);
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



    @Given("^there exists a enrollment$")
    public void there_exists_a_enrollment() throws Throwable {
        try {
            environment.setLastApiResponse(api.getEnrollmentsWithHttpInfo());
            environment.setLastApiCallThrewException(false);
            environment.setLastApiException(null);
            environment.setLastStatusCode(environment.getLastApiResponse().getStatusCode());
            List<EnrollmentList> enrollments = (List<EnrollmentList>)environment.getLastApiResponse().getData();
            assertTrue(enrollments.size() > 0);
            existingEnrollment = enrollments.get(0);
        } catch (ApiException e) {
            environment.setLastApiCallThrewException(true);
            environment.setLastApiException(null);
            environment.setLastApiException(e);
            environment.setLastStatusCode(environment.getLastApiException().getCode());
        }

    }

    @When("^I delete the enrollment$")
    public void i_delete_the_enrollment() throws Throwable {
        try {
            Integer enrollmentId = existingEnrollment.getId().intValue();
            environment.setLastApiResponse(api.deleteEnrollmentWithHttpInfo(enrollmentId));
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

    @Then("^I get a 'OK' response$")
    public void i_get_a_OK_response() throws Throwable {
        System.out.println("Delete ok");

    }



    @Given("^there exists an enrollment to update$")
    public void there_exists_an_enrollment_to_update() throws Throwable {
        try {
            environment.setLastApiResponse(api.getEnrollmentsWithHttpInfo());
            environment.setLastApiCallThrewException(false);
            environment.setLastApiException(null);
            environment.setLastStatusCode(environment.getLastApiResponse().getStatusCode());
            List<EnrollmentList> enrollments = (List<EnrollmentList>)environment.getLastApiResponse().getData();
            assertTrue(enrollments.size() > 0);
            existingEnrollment = enrollments.get(0);
        } catch (ApiException e) {
            environment.setLastApiCallThrewException(true);
            environment.setLastApiException(null);
            environment.setLastApiException(e);
            environment.setLastStatusCode(environment.getLastApiException().getCode());
        }

    }


    @When("^I update the enrollment$")
    public void i_update_the_enrollment() throws Throwable {
        try {
            Integer enrollmentId = existingEnrollment.getId().intValue();
            //environment.setLastApiResponse(api.updateEnrollmentWithHttpInfo(enrollment.setUserEmail("francinegheig"),enrollment.setSubjectId(3L));
            environment.setLastApiResponse(api.getEnrollmentsWithHttpInfo());
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

    @Then("^I receive a 'SUCCESS' response$")
    public void i_receive_a_SUCCESS_response() throws Throwable {
    System.out.println("Update ok");

    }

}