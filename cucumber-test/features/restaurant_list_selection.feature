Feature: Restaurant List Selection
	When the user is on the Restaurant page
	The user should see a list dropdown and selection

	Background:
		Given I am on the Restaurant Page

	Scenario: Dropdown Exists
		Then I should see a dropdown menu

	Scenario: Dropdown is Empty
		Then the dropdown value should be empty

	Scenario: Add To List Button Exists
		Then I should see a button labeled "Add to List"

	Scenario: Empty Selection
		When I press the "Add to List" Button
		Then I should be on the Restaurant Page

