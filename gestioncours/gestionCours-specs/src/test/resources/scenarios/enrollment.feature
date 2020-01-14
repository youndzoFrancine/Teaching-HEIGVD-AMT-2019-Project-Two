Feature: Creation of enrollments

  Scenario: create a enrollment
    Given I have a enrollment payload
    When I POST it to the /enrollments endpoint
    Then I receive a 201 status code
    And  I get a url location

  Scenario: Get an enrollment
    Given I  GET an existing enrollment
    When  I get a enrollment
    Then I receive  200 status code

  Scenario: Delete an enrollment
    Given there exists an enrollment to delete
    When I delete the enrollment
    Then I get a 'OK' response

  Scenario: Update enrollment
    Given there exists an enrollment to update
    When I update the enrollment
    Then I receive a 'SUCCESS' response