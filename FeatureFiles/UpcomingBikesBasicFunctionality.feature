Feature: Upcoming Honda Bike Basic Functionality

  @sanity @regression
  Scenario: Check the mouse hover action of new bikes dropdown
    Given the user is on the zigwheels home page
    When the user can mouse over upcoming bikes in new bikes dropdown
    Then the user can able to see the list of elements in new bikes dropdown.

  @sanity @regression
  Scenario: Check the click functionality of upcoming bikes in new bikes dropdown
    Given the user is on the zigwheels home page
    When the user select upcoming bikes in new bikes dropdown
    Then the user should be redirected to the Upcoming Bikes page

  @sanity @regression
  Scenario: Check the functionality of manufacturer dropdown
    Given the user is on the Upcoming bikes
    When the user select the manufacturer dropdown
    Then the user can able to see the list of bike models in dropdown.

  @sanity @regression
  Scenario: Check the functionality of manufacturer dropdown by selecting honda
    Given the user is on the Upcoming bikes
    When the user select the manufacturer dropdown
    And the user select honda in manufacturer dropdown
    Then the user should be redirected to the Honda Upcoming Bikes page

  @sanity @regression
  Scenario: Check the search box functionality
    Given the user is on the zigwheels home page
    When the user whether search box is enabled or disabled
    Then the user enter the upcoming honda bikes in search box
