Feature: Search Textbox Default
	When the user is on the search page
	The user should see a text box 
	With placeholder text "Enter food"

	Background:
		Given I am on the Search Page

	Scenario: User sees a text box 
		Then I should see two text boxes

	Scenario: Text box has a prompt value 
		Then the text box should have the prompt value "Enter Food"
