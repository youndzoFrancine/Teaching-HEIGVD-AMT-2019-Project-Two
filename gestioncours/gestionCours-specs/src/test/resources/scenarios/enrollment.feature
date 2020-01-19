Feature: Creation of enrollments

  Scenario: create a enrollment
    Given I have a enrollment payload
    When I POST it to the /enrollments endpoint
    Then I receive a '201' status code

  Scenario: Get an enrollment
    Given I  GET an existing enrollment
    When  I GET a enrollment
    Then I receive a '200' status code

  Scenario: get list of enrollment
    When I do a GET on the /enrollments endpoint
    Then I receive a '200' status code
    And the payload is a non-empty list

  Scenario: Delete an enrollment
    Given there exists an enrollment to delete
    When I DELETE on the /enrollments endpoints
    Then I receive a '200' status code

  Scenario: Update enrollment
    Given there exists an enrollment to update
    When I send a UPDATE on the /enrollments endpoint
    Then I receive a '201' status code