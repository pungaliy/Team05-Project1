Feature: Sort Reults
	Ensure all Restaurant are sorted by driving time
	Ensure all Recipes are sorted by prep time

	Scenario: Sort by time
	When I visit /ReturnResults?query=pizza&options=5
	Then the restaurants should be sorted by driving time

	Scenario: Sort by prep
	Given I wait 3 seconds
	When I visit /ReturnResults?query=pizza&options=5
	Then the recipes should be sorted by prep time

