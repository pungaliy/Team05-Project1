Feature: Collage
	When the user is on the results page
	The user should see a collage that follows the appearance specifications

	Background:
		Given I am on the Results Page

	Scenario: Collage Exists
		Then I should see a collage of images

	Scenario: Collage Dimensions
		Then the width the collage must be between 40 and 60 percent of viewport width
		And the height of the collage must be between 35 and 50 percent of viewport height

	Scenario: Ten photos
		Then there should be 10 photos in the collage
