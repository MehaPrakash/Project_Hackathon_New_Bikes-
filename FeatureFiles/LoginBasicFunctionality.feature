Feature: Login Basic Functionality

  @sanity @regression
  Scenario: Validating Login button
    Given the user is on the zigwheels home page
    When the user clicks on Login button
    Then the user redirected to Login/Register pop-up

  @sanity @regression
  Scenario: Validating Google button
    Given the user opens zigwheels site
    And the user navigates to ZigWheels login page
    When the user clicks on sign in with Google
    Then the user is redirected to Google Account Page
