package ch.heigvd.amt.gestioncours.spec.steps;

import ch.heigvd.amt.gestioncours.ApiException;
import ch.heigvd.amt.gestioncours.ApiResponse;
import ch.heigvd.amt.gestioncours.api.DefaultApi;
import ch.heigvd.amt.gestioncours.dto.EnrollmentList;
import ch.heigvd.amt.gestioncours.dto.Subject;
import ch.heigvd.amt.gestioncours.dto.SubjectList;
import ch.heigvd.amt.gestioncours.spec.helpers.Environment;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static org.junit.Assert.*;

public class SubjectSteps {
    private Environment environment;
    private DefaultApi api;

    Subject subject;
    SubjectList existingSubject;

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
            System.out.println("titi");
            lastApiResponse = api.createSubjectWithHttpInfo(subject);
            System.out.println("toto");
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
   /* @When("^I CREATE it to the /subjects endpoint$")
    public void i_CREATE_it_to_the_subjects_endpoint() throws Throwable {
        subject = new ch.heigvd.amt.gestioncours.dto.Subject();
        subject.setName("AMT");
        subject.setCreditsEtcs(10L);
        Subject subjectCreated = api.createSubject(subject);
        subjectCreated.getName();

    }
*/

    @Then("^the name is \"([^\"]*)\"$")
    public void the_name_is(String arg1) throws Throwable {
        assertEquals(arg1,((Subject)lastApiResponse.getData()).getName());
    }

    @Then("^the credits_etcs is (.+)$")
    public void the_credits_etcs_is(int arg1) throws Throwable {
        assertEquals(arg1,((Subject)lastApiResponse.getData()).getCreditsEtcs().intValue());
    }


    @Given("^I  GET an existing subject$")
    public void i_GET_an_existing_subject() throws Throwable {
        try {

            subject = new ch.heigvd.amt.gestioncours.dto.Subject();
            subject.setName("AMT");
            subject.setCreditsEtcs(10L);
            Integer subjectId = existingSubject.getId().intValue();
            lastApiResponse = api.getASubjectWithHttpInfo(subjectId.longValue());
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
            Integer subjectId = existingSubject.getId().intValue();
            lastApiResponse = api.getASubjectWithHttpInfo(subjectId.longValue());
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

    @When("^I send a GET on the /subjects endpoints$")
    public void i_send_a_GET_on_the_subjects_endpoints() throws Throwable {
        try {
            lastApiResponse = api.getSubjectsWithHttpInfo(1,12);
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

    @Then("^the payload is a non-empty list$")
    public void the_payload_is_a_non_empty_list() throws Throwable {
        subject = new ch.heigvd.amt.gestioncours.dto.Subject();
        subject.setName("AMT");
        subject.setCreditsEtcs(10L);


    }

    @Given("^there exists a subject to delete$")
    public void there_exists_a_subject_to_delete() throws Throwable {
        try {
            subject = new ch.heigvd.amt.gestioncours.dto.Subject();
            subject.setName("AMT");
            subject.setCreditsEtcs(10L);
            Integer subjectId = existingSubject.getId().intValue();
            lastApiResponse = api.getASubjectWithHttpInfo(subjectId.longValue());
            lastApiCallThrewException = false;
            lastApiException = null;
            lastStatusCode = lastApiResponse.getStatusCode();
            List<SubjectList> subjectLists = (List<SubjectList>)lastApiResponse.getData();
            assertTrue(subjectLists.size() > 0);
            existingSubject = subjectLists.get(0);
        } catch (ApiException e) {
            lastApiCallThrewException = true;
            lastApiResponse = null;
            lastApiException = e;
            lastStatusCode = lastApiException.getCode();
        }
    }

    @When("^I send a DELETE the /subjects/'id' endpoint$")
    public void i_send_a_DELETE_the_subjects_id_endpoint() throws Throwable {
        try {
            Integer subjectId = existingSubject.getId().intValue();
            lastApiResponse = api.deleteSubjectWithHttpInfo(subjectId);
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

    @Given("^there exists subject to update$")
    public void there_exists_subject_to_update() throws Throwable {
        try {
            Integer subjectId = existingSubject.getId().intValue();
            lastApiResponse = api.getASubjectWithHttpInfo(subjectId.longValue());
            lastApiCallThrewException = false;
            lastApiException = null;
            lastStatusCode = lastApiResponse.getStatusCode();
            List<SubjectList> subjectLists = (List<SubjectList>)lastApiResponse.getData();
            assertTrue(subjectLists.size() > 0);
            existingSubject = subjectLists.get(0);
        } catch (ApiException e) {
            lastApiCallThrewException = true;
            lastApiResponse = null;
            lastApiException = e;
            lastStatusCode = lastApiException.getCode();
        }
    }



    @When("^I send a UPDATE the /subjects endpoint$")
    public void i_send_a_UPDATE_the_subjects_endpoint() throws Throwable {
        try {
            subject = new ch.heigvd.amt.gestioncours.dto.Subject();
            subject.setName("AMT");
            subject.setCreditsEtcs(10L);
            environment.setLastApiResponse(api.updateSubjectWithHttpInfo(1,subject ));
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


    @When("^I GET a subject to the /subjects endpoint$")
    public void i_GET_a_subject_to_the_subjects_endpoint() throws Throwable {
        try {
            Integer subjectId = existingSubject.getId().intValue();
            lastApiResponse = api.getASubjectWithHttpInfo(subjectId.longValue());
            lastApiCallThrewException = false;
            lastApiException = null;
            lastStatusCode = lastApiResponse.getStatusCode();
        } catch (ApiException e) {
            System.out.println(e);
            lastApiCallThrewException = true;
            lastApiResponse = null;
            lastApiException = e;
            lastStatusCode = lastApiException.getCode();
        }
    }



}
