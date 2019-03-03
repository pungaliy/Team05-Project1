package edu.usc.cs310.proj1.objects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class ImagesRequest {
	
	public ArrayList<String> imageResultURLs = new ArrayList<String>();

	String urlOfPrintable;
	
	String urlOfSearch;
	String searchTerm;
	Integer numResults;
	
	public ImagesRequest(String query) {
		searchTerm = query;
	}
	
//	private void request() {
//		
//		//first step is to grab numResults recipes to get from the search page
//		//based on https://www.allrecipes.com/search/results/?wt=chicken&sort=re
//		
//		urlOfSearch = "https://www.google.com/search?q=" + searchTerm + "&source=lnms&tbm=isch&sa=X&ved=0ahUKEwi3zPbF5ebgAhUn34MKHQcRDwEQ_AUIDygC&biw=1440&bih=711";
//
//		WebClient client = new WebClient();  
//		client.getOptions().setCssEnabled(false);  
//		client.getOptions().setJavaScriptEnabled(false);
//		
//		HtmlPage page = null;
//		
//		try {  
//		  page = client.getPage(urlOfSearch);
//		}catch(Exception e){
//		  e.printStackTrace();
//		}
//		
//		//from this page, we need to pull the following values
//		
//		List<HtmlElement> items = (List<HtmlElement>) page.getByXPath("//img"); 
//		
//		for (int i = 0; i < 10; i++) {
//			
//			HtmlElement item = items.get(i);
//			HtmlAnchor itemAnchor = ((HtmlAnchor)item.getFirstByXPath("//*[@id=\"NlmiHarYJuIZfM:\"]"));
//			
//			//load a new result item into our arraylists for later parsing
//			
//			//recipes are noted by the <article class="fixed-recipe-card">
//			//the following values are all within thius article class for that specific recipe
//			
//			//grab image urls from here ...
//			//data-imageurl="url.com"
//			
//			//we can grab a URL from here...
//			//<a href="https://www.allrecipes.com/recipe/228293/curry-stand-chicken-tikka-masala-sauce/"
//			//TO THIS WE SHOULD ADD "print" to get a simplified page to scrape
//			
//			imageResultURLs.add(itemAnchor.getHrefAttribute() + "print");
//		}
//		
//		
//		
//		//from this page, we need to pull the following values
//	
//		for (String i : recipeURLs) {
//			
//			client = new WebClient();  
//			client.getOptions().setCssEnabled(false);  
//			client.getOptions().setJavaScriptEnabled(false);
//			
//			page = null;
//			
//			try {  
//			  page = client.getPage(i);
//			}catch(Exception e){
//			  e.printStackTrace();
//			}
//			
//			//begin analysis of printable page
//			//we need to create a new recipe object with the following information
//			
//			String recipeName;
//			
//			String imageLink;
//			
//			String prepTime;
//			String cookTime;
//			ArrayList<String> ingredients = new ArrayList<String>();
//			ArrayList<String> instructions = new ArrayList<String>();
//			
//			//recipe name is page title
//			items = (List<HtmlElement>) page.getByXPath("//title");
//			
//			recipeName = items.get(0).asText();
//			String[] split = recipeName.split("Printer");
//			recipeName = split[0].substring(0, split[0].length()-3);
//			
//			//prep time
//			items = (List<HtmlElement>) page.getByXPath("//time");
//			prepTime = items.get(0).asText();
//			//cook time
//			cookTime = items.get(1).asText();
//			
//			//image URL
//			
//			//img class="recipe-print__recipe-img"
//			items = (List<HtmlElement>) page.getByXPath("//img[@class='recipe-print__recipe-img']");
//			imageLink = items.get(0).getAttribute("src");
//			
//			
//			//ingredients
//			items = (List<HtmlElement>) page.getByXPath("//ul");
//			
//			ingredients.add(items.get(25).asText());
//			ingredients.add(items.get(26).asText());
//			
//			//instructions
//			items = (List<HtmlElement>) page.getByXPath("//ol[@class='recipe-print__directions']");
//			//<ol class="recipe-print__directions">
//			for (HtmlElement j : items) {
//				instructions.add(j.asText());
//			}
//			
//			recipeResults.add(new Recipe(recipeName, imageLink, prepTime, cookTime, ingredients, instructions));
//		}
//		
//	}

	public static void main (String args []) {
		ImagesRequest ir = new ImagesRequest("carrot");
		
		
	}

}