Feature: Creation of subjects

  Background:
    Given there is a Subjects server

  Scenario: create a subject
    Given I have a subject payload
    When I POST it to the /subjects endpoint
    And the request body is
      """
        {
        "name": "AMT",
        "credits_etcs": 10
        }
      """
    Then I receive a 201 status code
    And the response body contains
      """
      "id":
      """

  Scenario: Get subject
    Given I  GET an existing subject
    When  I get a subject
    Then I receive  a '200' status code

  Scenario: get list of subject
    When I send a GET on the /subjects endpoints
    Then I receive a '200' status code
    And the payload is a non-empty list

  Scenario: Delete subject
    Given there exists a subject to delete
    When I send a DELETE the subject
    Then I receive a '200' status code

  Scenario: Update subject
    Given there exists subject to update
    When I send a UPDATE the subject
    Then I receive a '200' status code
