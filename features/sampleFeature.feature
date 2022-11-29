@login
Feature: Login functionality

  Background: 
    Given User on login page pre requisite

  @loginFunctionlity @positive
  Scenario: Validate Login Functionality
    Given User on login page
    When user enters username "Admin" and password "admin123"
    Then User should successfully login <language>
      | language    |
      | java        |
      | python      |
      | java script |
    When User clicks on logout
    Then user should be on login page

@loginFunctionlity @negative
  Scenario Outline: Validate Login Functionality
    Given User on login page
    When user enters username '<userName>' and password '<password>'
    Then User should successfully login
    When User clicks on logout
    Then user should be on login page

    Examples: 
      | userName | password  |
      | Admin    | admin123  |
      | Random   | admin123  |
      | Admin    | random123 |
