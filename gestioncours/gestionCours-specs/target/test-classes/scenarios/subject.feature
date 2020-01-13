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

  Scenario: Delete subject
    Given there exists a subject to delte
    When I DELETE the subject
    Then I get a 'OK DELECTED' response

  Scenario: Update subject
    Given there exists subject to update
    When I UPPDATE the subject
    Then I get a 'SUCCESS UPDATED' response
