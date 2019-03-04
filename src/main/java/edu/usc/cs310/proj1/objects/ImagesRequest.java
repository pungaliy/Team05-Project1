package edu.usc.cs310.proj1.objects;

import java.util.ArrayList;
import java.util.List;

import com.gargoylesoftware.htmlunit.WebClient;
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
	
	private void request() {
		
		//first step is to grab numResults recipes to get from the search page
		//based on https://www.allrecipes.com/search/results/?wt=chicken&sort=re
		
		urlOfSearch = "https://www.google.com/search?q=" + searchTerm + "&source=lnms&tbm=isch&sa=X&ved=0ahUKEwi3zPbF5ebgAhUn34MKHQcRDwEQ_AUIDygC&biw=1440&bih=711";

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
		
		List<HtmlElement> items = (List<HtmlElement>) page.getByXPath("//img"); 
		
		for (int i = 0; i < 10; i++) {
			
			
			String imageLink;

			items = (List<HtmlElement>) page.getByXPath("//img");
			imageLink = items.get(0).getAttribute("src");
			
			imageResultURLs.add(imageLink);
		}
		
	}

	public static void main (String args []) {
		ImagesRequest ir = new ImagesRequest("carrot");
		
		
	}

}
