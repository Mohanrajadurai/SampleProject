Feature: Login for Facebook

  Background: 
    Given Launch the Browser
    And Enter the URL

  @sce1
  Scenario: Enter the valid password and valid password
    When Enter the valid Username "Mohan"
    And Enter the valid Password "Test@123"
    And Click the LoginButton
    Then Validate the HomePage

  @sce2
  Scenario: Enter the invalid password and invalid password
    When Enter the valid Username "Mohann"
    And Enter the valid Password "Test@1234"
    And Click the LoginButton
    Then Validate the HomePage
