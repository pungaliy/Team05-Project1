Feature: Restaurant Information	
	Ensure all necessary information is present on the page

	Background:
		Given I am on the Restaurant Page

	Scenario: Name
		Then I should see the name of the Restaurant

	Scenario: Address
		Then I should see an address

	Scenario: Phone Number
		Then I should see a phone number

	Scenario: Website Link
		Then I should see a website link

	