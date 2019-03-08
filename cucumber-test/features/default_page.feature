Feature: Default Page
	The user should get to the search page 
	Upon receiving any of the following URLs

	Scenario Outline: 
	    When I visit <Page>
	    Then I should be on the Search page

	Examples:
	    | Page |
	    | |
