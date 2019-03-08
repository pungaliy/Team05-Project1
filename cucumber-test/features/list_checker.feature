Feature: Check list functionality (add, remove, filtration in results)

	Background:
		Given I have added the "Big Smokey Burgers" to the "Favorite" page
		And I have added the "Traditions" to the "Do Not Show" page
		And I am on the Results page

	Scenario: Items filtered
		When I am on the Results page
		Then "Traditions" should not be there
		And "Big Smokey Burgers" should be the first recipe

	Scenario:
		When I am on the Do Not Show page
		And I click on "Remove"
		Then "Traditions" should not be there
	
	Scenario:
		When I am on the Favorite page
		And I click on "Move To..."
		And I choose the "Do Not Show" list
		Then "Big Smokey Burgers" should not be there
		And "Big Smokey Burgers" should be on the "Do Not Show" page

	Scenario: Items in lists
		Then "Traditions" should be on the "Do Not Show" page
		And "Big Smokey Burgers" should be on the "Favorite" page




