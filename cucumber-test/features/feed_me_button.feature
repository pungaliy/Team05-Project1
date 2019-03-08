Feature: Feed Me Button
	When the user is on the search page
	The user should see a button labeled "Feed Me!" 
	Unclicked, grumpy emoji
	Clicked, smiley emoji
	After clicking, either redirect or error message

	Background:
		Given I am on the Search Page

	Scenario: The user sees a button labeled "Feed Me!"
		Then I should see a button labeled "Feed Me!"

	Scenario: The color of "Feed Me!" is not black
		Then the color of the "Feed Me!" button should not be black

	Scenario: Empty search box
			Given the search box is empty
			When I click the "Feed Me!" button
		Then I should see no change

	Scenario Outline: Empty search box
		Given the search box has value "<value>"
		When I click the "Feed Me!" button
		Then I should get be redirected to the Results Page
		And the title of the Results page should say "Results for <value>"

	Examples:
		| value |
		| hamburger |

