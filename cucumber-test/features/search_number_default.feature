Feature: Search Number Default
	When the user is on the search page
	The user should see a text box 
	With default value of 5

	Background:
		Given I am on the Search Page

	Scenario: User sees a text box for a number
		Then I should see two text boxes

	Scenario: Text box has a default of 5 
		Then the text box should have a default value of 5

  Scenario Outline: Text box allows integers above 0
	When I enter "hamburger" into the search box
	And I enter <number_pos> into the number box
	And I click the "Feed Me!" button 
	Then I should be on the Results Page

	Examples:
		| number_pos |
		| 1 |
		| 2 |
		| 5 |

  Scenario Outline: Text box does not allow integers below 1
	When I enter <number_neg> into the number box
	Then I should see no change

  Examples:
	| number_neg |
		| 0 |
		| -1 |
		| -5 |
		| -20 |
		| -100 |
