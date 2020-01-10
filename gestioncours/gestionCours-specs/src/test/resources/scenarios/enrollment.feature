Feature: Creation of enrollments

  Scenario: create a enrollment
    Given I have a enrollment payload
    When I POST it to the /enrollments endpoint
    Then I receive a 201 status code

<<<<<<< HEAD
=======
  Scenario: Get an enrollment
    Given I  GET an existing enrollment
    When  I get a enrollment
    Then I receive  200 status code




>>>>>>> 63dd7b6021b3903ddab9bf1535649138ff826dc5
  Scenario: Delete enrollment
    Given there exists a enrollment
    When I delete the enrollment
    Then I get a 'OK' response