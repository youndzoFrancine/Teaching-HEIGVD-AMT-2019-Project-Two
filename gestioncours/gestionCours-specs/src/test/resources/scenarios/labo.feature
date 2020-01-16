Feature: Creation of Labo

  Scenario: create a labo
    Given I have a labo payload
    When I POST it to the /labos endpoint
    Then I receive a 201 status code

  Scenario: Get a labo
    Given I  GET an existing labo
    When  I get a labo
    Then I receive  200 status code


  Scenario: Delete labo
    Given there exists an labo to delete
    When I DELETE the labo
    Then I receive valid HTTP response code 200 for "DELETE."

  Scenario: Update labo
    Given there exists an labo to update
    When I UPDATE the labo
    Then I receive a 201 status code