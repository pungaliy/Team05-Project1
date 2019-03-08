Feature: Results Title
	The title of the results page should correspond to the value that was searched

	Background:
		Given I am on the Search Page

	Scenario Outline: Correct Title
	    When I enter "<value>" into the search box
	    And I click the "Feed Me!" button
	    Then I should see the title "Results for <value>"

	Examples:
		| value |
		| hamburger |
