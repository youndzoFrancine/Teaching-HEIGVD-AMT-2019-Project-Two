Feature: User Logging functionnality

  Scenario: Logging in with invalid credentials
    Given I am at the /authenticate page
    When  I fill the email textbox with an incorrect value
    And   I fill the password textbox with an incorrect value
    And   I click the login button
    Then  I receive a status code 400
    And   a text 'Can't login! Wrong firstname or lastname or email or password.' should appear in the validation error

  Scenario: Logging in with valid credentials
    Given I am at the /authenticate page
    When  I fill the email textbox with the correct value
    And   I fill the password textbox with an correct value
    And   I click the login button
    Then  I receive a status code 200
    And   I should be at the home page