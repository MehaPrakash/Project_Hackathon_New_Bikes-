Feature: Used popular car models basic functionality

  @sanity @regression
  Scenario: Check the mouse hover action of used cars dropdown
    Given the user is on the zigwheels home page
    When the user can mouse over used cars dropdown
    Then the user can able to see the chennai in used cars dropdown.

  @sanity @regression
  Scenario: Check the functionality of navigating to used cars in chennai page
    Given the user is on the zigwheels home page
    When the user can mouse over used cars dropdown
    And click on chennai in used cars dropdown
    Then the user should be redirected to the Used cars in chennai page

  @sanity @regression
  Scenario: Check the navigation from used car page to home page
    Given the user is on the used cars page
    When the user click on home link
    Then user navigate to the home page
