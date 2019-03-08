Feature: Printable View
	Make sure the appropriate pages have a printable view button

	Scenario Outline: Printable View
		Given I am on the <Page> Page
		Then I should see a Printable View button

	Examples:
		| Page |
		| Recipe |
		| Restaurant |
