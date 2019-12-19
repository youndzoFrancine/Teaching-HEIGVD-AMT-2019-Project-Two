Feature: Creation of subjects

  Background:
    Given there is a Subjects server

  Scenario: create a subject
    Given I have a subject payload
    When I POST it to the /subjects endpoint
    Then I receive a 201 status code