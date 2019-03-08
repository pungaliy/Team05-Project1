Feature: Recipe Information	
	Ensure all necessary information is present on the page

	Background:
		Given I am on the Recipe Page

	Scenario: Title
		Then I should see the title of the Recipe

	Scenario: Picture
		Then I should see an image

	Scenario: Prep Time
		Then I should see the prep time for the dish

	Scenario: Cook Time
		Then I should see the cook time for the dish

	Scenario: Ingredients
		Then I should see a list of ingredients for the dish

	Scenario: Instructions
		Then I should see a list of instructions for the dish
		
