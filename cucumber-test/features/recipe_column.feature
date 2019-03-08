Feature: Recipe Column
	When the user is on the results page
	The user should see a recipe column

	Background:
		Given I am on the Results Page

	Scenario: Title Exists
		Then I should see the "Recipe" title

	Scenario: Recipe Values Correct
		Then a recipe should have a Name, Stars, Prep time, Cook time

	Scenario: Recipe Redirection
		When I click on a Recipe
		Then I should be redirected to that Recipe's page
