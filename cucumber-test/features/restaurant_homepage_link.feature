Feature: Restaurant Homepage Link
	Clicking on website redirects to Restaurant Homepage

	Background:
		Given I am on the Restaurant Page
	
	Scenario: Redirection
		When I click the website
		Then I should be redirected to that website