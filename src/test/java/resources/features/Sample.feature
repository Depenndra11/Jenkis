Feature: Sample Login Feature

  Scenario: Successful Login
    Given User is on the login page
    When User enters valid credentials
    Then User should be redirected to the dashboard
