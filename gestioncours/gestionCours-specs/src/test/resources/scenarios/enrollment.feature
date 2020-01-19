Feature: Creation of enrollments
  Background:
    Given there is a Enrollments server

  Scenario: create a enrollment
    Given I have a enrollment payload
    When I POST it to the /enrollments endpoint
    Then I receive a '201' status code

  Scenario: get a list of all the subjects
    When I send a GET on the /enrollments endpoints
    Then I receive a '200' status code

  Scenario: Delete an enrollment
    Given there exists an enrollment to delete
    When I send a DELETE to the /enrollments endpoints
    Then I receive a '200' status code
