Feature: Test CRUD methods in subject

  Scenario: Get subject
    Given I Set GET subject service api endpoint
    When  I Set request HEADER
    And  Send GET HTTP request
    Then I receive  200 status code

