Feature: Creation of Labo

  Scenario: create a labo
    Given I have a labo payload
    When I POST it to the /labos endpoint
    And the request body is
      """
        {
        "name": "doggie",
        "status": "available"
        }
      """
    Then I receive a 201 status code
    And the response body contains
      """
      "id":
      """

  Scenario: Get a labo
    Given I  GET an existing labo
    When  I GET a labo
    Then I receive  200 status code

  Scenario: get list of labo
    When I do a GET on the /labos endpoint
    Then I receive a 200 status code
    And the payload is a non-empty list

  Scenario: Delete labo
    Given there exists an labo to delete
    When I send DELETE on the /labos endpoint
    Then Then I receive  200 status code

  Scenario: Update labo
    Given there exists an labo to update
    When I send an UPDATE on the /labo endpoint
    Then I receive a 201 status code