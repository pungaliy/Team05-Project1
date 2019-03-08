Feature: Remove Or Move Item
	If I remove or move an item, it should no longer show on the current page

	Scenario Outline: Remove Item
		Given I am on the <Page> page
	    When I click the "Remove" button
	    Then I should no longer see the item

	Examples:
		| Page |
		| Favorites |
		| Do Not Show |
		| To Explore |

	Scenario Outline: Move Item
		Given I am on the <Page> page
	    When I click the "Move" button
	    Then I should no longer see the item

	Examples:
		| Page |
		| Favorites |
		| Do Not Show |
		| To Explore |