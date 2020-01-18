
package ch.heigvd.amt.authentication.spec.steps;

import ch.heigvd.amt.authentication.api.DefaultApi;
import ch.heigvd.amt.authentication.dto.User;
import ch.heigvd.amt.authentication.spec.helpers.Environment;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UserLoggingSteps {
    private Environment environment;
    private DefaultApi api;
    User user;

    //EnrollmentList existingEnrollment;



    public UserLoggingSteps(Environment environment) {
        this.environment = environment;
        this.api = environment.getApi();
    }

    @Given("^I am at the /authenticate page$")
    public void i_am_at_the_authenticate_page() throws Throwable {
       // environment.getApi().createUserWithHttpInfo(user).;
    }


    @When("^I fill the email textbox with an incorrect value$")
    public void i_fill_the_email_textbox_with_an_incorrect_value() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I fill the password textbox with an incorrect value$")
    public void i_fill_the_password_textbox_with_an_incorrect_value() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I click the login button$")
    public void i_click_the_login_button() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I receive a status code (\\d+)$")
    public void i_receive_a_status_code(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^a text 'Can't login! Wrong firstname or lastname or email or password\\.' should appear in the validation error$")
    public void a_text_Can_t_login_Wrong_firstname_or_lastname_or_email_or_password_should_appear_in_the_validation_error() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I fill the email textbox with the correct value$")
    public void i_fill_the_email_textbox_with_the_correct_value() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I fill the password textbox with an correct value$")
    public void i_fill_the_password_textbox_with_an_correct_value() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I should be at the home page$")
    public void i_should_be_at_the_home_page() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }


}