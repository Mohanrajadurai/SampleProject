Feature: LoginPage for Facebook

  Background: 
    Given Launch the Browser
    And Enter the URL

  @sce3
  Scenario Outline: Validate the username and password
    When Enter the user "<username>"
    And Enter the pass "<password>"
    And Click the Login
    Then Validate the Home

    Examples: 
      | username | password |
      | Aiite1   | Test1    |
      | Aiite2   | Test2    |
      | Aiite3   | Test3    |
