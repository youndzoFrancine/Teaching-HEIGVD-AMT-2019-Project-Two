Feature: Creation of subjects

  Background:
    Given there is a Subjects server

  Scenario: create a subject
    Given I have a subject payload
    When I POST it to the /subjects endpoint
    Then I receive a 201 status code

  Scenario: Get subject
    Given I  GET an existing subject
    When  I get a subject
    Then I receive  200 status code