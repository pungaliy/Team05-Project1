Feature: Return To Results
	When a person clicks this button on a page
	They return to the search results page

	Scenario Outline: Click Button
		Given I am on the <Page> Page
		When I click the "Back to Results" button
		Then I should be on the Results Page

	Examples:
	| Page |
	| Favorites |
	| Do Not Show |
	| To Explore |


	Scenario Outline: Click Button
		Given I am on the <Page> Page
		When I click the "Return To Results" button
		Then I should be on the Results Page

	Examples:
	| Page |
	| Recipe |
	| Restaurant |


