Feature: Google Maps Link
	Clicking on address redirects to Google Maps with starting point Tommy Trojan

	Background:
		Given I am on the Restaurant Page
	
	Scenario: Google Maps Link
		When I click the address
		Then I should be redirected to Google Maps
		And the starting address should be Tommy Trojan
		And the desination address should be filled in