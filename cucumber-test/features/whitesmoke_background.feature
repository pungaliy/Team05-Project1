Feature: Whitesmoke background
	Check that the background of all pages are Whitesmoke

	Scenario Outline: 
	    Given I am on the <Page> Page
	    Then the background color is Whitesmoke

	Examples:
		| Page |	
	    | Search		|
	    | Results		|
	    | Restaurant	|
	    | Recipe   		|
	    | Favorites		|
	    | Do Not Show	|
	    | To Explore	|

