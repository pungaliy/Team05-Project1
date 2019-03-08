Feature: Is it friday yet?
	Everyone wants to know when it's friday

	Scenario: Sunday isn't Friday
		Given today is Sunday
		When I ask whether it's Friday yet
		Then I should be told "Nope"
		
