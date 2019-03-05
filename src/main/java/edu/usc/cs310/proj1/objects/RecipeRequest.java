package edu.usc.cs310.proj1.objects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class RecipeRequest {
	
	public ArrayList<Recipe> recipeResults = new ArrayList<Recipe>();
	
	public ArrayList<String> recipeURLs = new ArrayList<String>();
	public ArrayList<String> recipeNames = new ArrayList<String>();
	public ArrayList<String> recipeImageURLs = new ArrayList<String>();
	
	String urlOfPrintable;
	
	String urlOfSearch;
	String searchTerm;
	Integer numResults;
	
	public RecipeRequest(String query, int options) {
		searchTerm = query;
		
		if (!searchTerm.matches("[a-zA-Z]+")) {
			searchTerm = ".";
		}
		
		numResults = options;
		
		this.request();
	}
	
	private void request() {
		
		//first step is to grab numResults recipes to get from the search page
		//based on https://www.allrecipes.com/search/results/?wt=chicken&sort=re
		
		urlOfSearch = "https://www.allrecipes.com/search/results/?wt=" + searchTerm + "&sort=re";

		WebClient client = new WebClient();  
		client.getOptions().setCssEnabled(false); 
		client.getOptions().setJavaScriptEnabled(false);
		
		HtmlPage page = null;
		
		try {  
		  page = client.getPage(urlOfSearch);
		}catch(Exception e){
		  e.printStackTrace();
		}
		
		//from this page, we need to pull the following values
		
		List<HtmlElement> items = (List<HtmlElement>) page.getByXPath("//article[@class='fixed-recipe-card']"); 
		
		if (items.size() < numResults) {
			numResults = items.size();
		}
		
		for (int i = 0; i < numResults; i++) {
			
			HtmlElement item = items.get(i);
			HtmlAnchor itemAnchor = ((HtmlAnchor)item.getFirstByXPath(".//a"));
			
			//load a new result item into our arraylists for later parsing
			
			//recipes are noted by the <article class="fixed-recipe-card">
			//the following values are all within thius article class for that specific recipe
			
			//grab image urls from here ...
			//data-imageurl="url.com"
			
			//we can grab a URL from here...
			//<a href="https://www.allrecipes.com/recipe/228293/curry-stand-chicken-tikka-masala-sauce/"
			//TO THIS WE SHOULD ADD "print" to get a simplified page to scrape
			
			recipeURLs.add(itemAnchor.getHrefAttribute() + "print");
		}
		
		//from this page, we need to pull the following values
	
		for (String i : recipeURLs) {
			
			client = new WebClient();  
			client.getOptions().setCssEnabled(false);  
			client.getOptions().setJavaScriptEnabled(false);
			
			page = null;
			
			try {  
			  page = client.getPage(i);
			}catch(Exception e){
			  e.printStackTrace();
			}
			
			//begin analysis of printable page
			//we need to create a new recipe object with the following information
			
			String recipeName;
			
			String imageLink;
			
			String prepTime;
			String cookTime;
			ArrayList<String> ingredients = new ArrayList<String>();
			ArrayList<String> instructions = new ArrayList<String>();
			
			//recipe name is page title
			items = (List<HtmlElement>) page.getByXPath("//title");
			
			recipeName = items.get(0).asText();
			String[] split = recipeName.split("Printer");
			recipeName = split[0].substring(0, split[0].length()-3);
			
			//prep time
			items = (List<HtmlElement>) page.getByXPath("//time");
			
			if (items.size() > 1) {
				prepTime = items.get(0).asText();
				//cook time
				cookTime = items.get(1).asText();
			} else {
				prepTime = "";
				cookTime = "";
			}
			
			//image URL
			
			//img class="recipe-print__recipe-img"
			items = (List<HtmlElement>) page.getByXPath("//img[@class='recipe-print__recipe-img']");
			
			if (items.size() > 0) {
				imageLink = items.get(0).getAttribute("src");
			} else {
				imageLink = "";
			}
			
			
			//ingredients
			items = (List<HtmlElement>) page.getByXPath("//ul");
			
			if (items.size() > 25) {
				ingredients.add(items.get(25).asText());
				ingredients.add(items.get(26).asText());
			} else {
				ingredients.add("");
				ingredients.add("");
			}
			
			//instructions
			items = (List<HtmlElement>) page.getByXPath("//ol[@class='recipe-print__directions']");
			//<ol class="recipe-print__directions">
			for (HtmlElement j : items) {
				instructions.add(j.asText());
			}
			
			//clean data before adding
			for (String f : ingredients) {
				f = f.replaceAll("\'", "\\\\'");
				f = f.replaceAll("\"","\\\\\"");
			}
			
			for (String f : instructions) {
				f = f.replaceAll("\'", "\\\\'");
				f = f.replaceAll("\"","\\\\\"");
			}
			
			
			recipeResults.add(new Recipe(recipeName, imageLink, prepTime, cookTime, ingredients, instructions));
		}
		
	}

	public static void main (String args []) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("What would you like to search?");
		String query = scan.nextLine();
		System.out.println("How many search results?");
		int options = scan.nextInt();
		scan.nextLine();
		RecipeRequest y = new RecipeRequest(query, options);
		
		System.out.println("");
		
		for (Recipe i : y.recipeResults) {
			System.out.println(i.recipeName);
			System.out.println("Image URL: " + i.imageLink);
			System.out.println("Prep Time: " + i.prepTime);
			System.out.println("Cook Time: " + i.cookTime);
			System.out.println("Ingredients: ");
			for (String j : i.ingredients) {
				System.out.println(j);
			}
			System.out.println("Instructions: ");
			for (String j : i.instructions) {
				System.out.println(j);
			}
			System.out.println("");
		}
		
	}

}