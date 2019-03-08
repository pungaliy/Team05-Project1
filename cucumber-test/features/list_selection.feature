Feature: List Selection
	When the user is on the results page
	The user should see a list management dropdown and selection

	Scenario Outline: Empty Selection
		Given I am on the <Page> Page
	    When I press the "Manage List" Button
	    Then I should be on the <Page> Page 

	    Examples:
		| Page |
		| Results | 
		| Favorite |
		| Do Not Show |
		| To Explore |


	Scenario Outline: Correct redirection
		Given I am on the <Page> Page
		When I select "<select_page>" from the dropdown
		And I press the "Manage List" Button
		Then I should be on the <select_page> Page

	Examples:	
		| Page | select_page |
		| To Explore | Do Not Show |
		| Results | Do Not Show |
		| Results | Favorite |
		| Results | To Explore |
		| Favorite | Favorite |
		| Favorite | Do Not Show |
		| Favorite | To Explore |
		| Do Not Show | Favorite |
		| Do Not Show | Do Not Show |
		| Do Not Show | To Explore |
		| To Explore | Favorite |
		| To Explore | Do Not Show |
		| To Explore | To Explore |


	Scenario Outline: Dropdown Exists
		Given I am on the <Page> Page
	    Then I should see a dropdown menu

	Examples:
		| Page |
		| Results | 
		| Favorite |
		| Do Not Show |
		| To Explore |

	Scenario Outline: Dropdown is Empty
		Given I am on the <Page> Page
		Then the dropdown value should be empty

	Examples:
		| Page |
		| Results | 
		| Favorites |
		| Do Not Show |
		| To Explore |

	Scenario Outline: Manage List Button Exists
		Given I am on the <Page> Page
	    Then I should see a button labeled "Manage List"

	Examples:
		| Page |
		| Results | 
		| Favorites |
		| Do Not Show |
		| To Explore |

	
