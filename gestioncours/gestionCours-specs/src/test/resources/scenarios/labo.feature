Feature: Creation of labos

  Background:
    Given there is a Labos server

  Scenario: create a labo
    Given I have a labo  payload
    When I POST it to the /labos endpoint
    Then I receive a '201' status code

  Scenario: Get a labo
    Given I  get an existing labo
    When  I send a GET to the /labos endpoints
    Then I receive  '200' status code

  Scenario: get a list of all the subjects
    When I send a GET to the /labos endpoints
    Then I receive a '200' status code

  Scenario: Delete labo
    Given there exists a labo to delete
    When I send a DELETE to the /labos endpoints
    Then I receive a '200' status code

  Scenario: Update labo
    Given I have a labo payload
    When I send a UPDATE to the /labos endpoints
    Then I receive a '200' status code
