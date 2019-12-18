Feature: Creation of enrollments

  Background:
    Given there is a Enrollments server

  Scenario: create a enrollment
    Given I have a enrollment payload
    When I POST it to the /enrollments endpoint
    Then I receive a 201 status code