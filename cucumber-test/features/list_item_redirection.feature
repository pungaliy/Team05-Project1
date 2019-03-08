Feature: List Item Redirection
	When the user is on a list management page
	The user should be redirected to an item's page if they click on it

	Scenario: Redirection
		Given I have added the "Big Smokey Burgers" to the "Favorite" page
		And I am on the Favorites page
		When I click on "Big Smokey Burgers"
		Then I should be on the Recipe page
