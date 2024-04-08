Feature: Upcoming honda bike details under 4 lakhs

  @regression
  Scenario: Verify the retrieval of honda bikes whose price is less than 4 lakhs
    Given the user is on the honda Upcoming Bikes page
    When the user able to see honda upcoming bikes under 4 lakhs by clicking Read more options
    Then display those prices
