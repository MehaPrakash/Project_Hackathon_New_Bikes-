Feature: Login Test Data Driven Excel
  
  @regression
  Scenario Outline: Login with invalid credentials
  	Given the user opens zigwheels site
  	And the user navigates to ZigWheels login page
  	When the user clicks on sign in with Google
  	And the user enters the invalid email id with the excel row "<row_index>"
    And the user clicks next
  	Then the user should see error on the login page
  	
  	Examples:
	| row_index |
	|          1|
	|          2|
	|          3|
	|          4|
	|          5|
	|          6|
	|          7|
	|          8|
	|          9|
	|          10|
	
	
	
