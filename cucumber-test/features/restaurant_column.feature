Feature: Restaurant Column
	When the user is on the results page
	The user should see a restaurant column

	Background:
		Given I am on the Results Page

	Scenario: Title Exists
		Then I should see the "Restaurant" title

	Scenario: Restaurant Values Correct
		Then a restaurant should have a Name, Address, Stars, Minutes, and Price Range

	Scenario: Restaurant Redirection
		When I click on a Restaurant
		Then I should be redirected to that Restaurant's page
