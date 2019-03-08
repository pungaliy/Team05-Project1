Feature: Return to Search
	When a person clicks this button on a page
	They return to the search page

	Scenario Outline: Click Button
		Given I am on the <Page> Page
		When I click the "Back to Search" button
		Then I should be on the Search Page

	Examples:
	| Page |
	| Favorites |
	| Do Not Show |
	| To Explore |

	Scenario Outline: Click Button
		Given I am on the <Page> Page
		When I click the "Return to Search Page" button
		Then I should be on the Search Page

	Examples:
	| Page |
	| Results |