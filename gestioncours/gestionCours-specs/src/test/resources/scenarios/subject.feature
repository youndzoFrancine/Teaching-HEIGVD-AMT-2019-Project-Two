Feature: Creation of subjects

  Background:
    Given there is a Subjects server

  Scenario: create a subject
    Given I have a subject payload
    When I POST it to the /subjects endpoint
    Then I receive a '201' status code

  Scenario: Get a subject
    Given I  GET an existing subject
    When  I send a GET to the /subjects endpoints
    Then I receive  200 status code

  Scenario: get a list of all the subjects
    When I send a GET to the /subjects endpoints
    Then I receive a '200' status code

  Scenario: Delete subject
    Given there exists a subject to delete
    When I send a DELETE to the /subjects endpoint
    Then I receive a '200' status code

  Scenario: Update subject
    Given I have a subject payload
    When I send a UPDATE to the /subjects endpoint
    Then I receive a '200' status code
