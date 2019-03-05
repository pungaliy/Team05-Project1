package edu.usc.cs310.proj1.objects;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ImagesRequest {
	
	public ArrayList<String> imageResultURLs = new ArrayList<String>();

	String urlOfPrintable;
	
	String urlOfSearch;
	String searchTerm;
	Integer numResults;
	
	public ImagesRequest(String query) {
		searchTerm = query;
		this.request();
	}
	
	private void request() {
		
		urlOfSearch = "https://www.googleapis.com/customsearch/v1?q=" + searchTerm + "&cx=010424164654780185781%3Adwdzcylugra&num=10&searchType=image&key=AIzaSyCUBryJarHnnYvjEdJuI48R2ATEv3OvuP4";
		
		String storeJson = "";
		
		try {
			
			//GET request to custom search api
			
			URL url = new URL(urlOfSearch);
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
			
			String strTemp = "";
			
			//Store results of api call to storeJson string
			
			while ((strTemp = br.readLine()) != null) {
				storeJson += strTemp;
				storeJson += "\n";
			}
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		//pull links from stored json response
		
		JsonObject jsonObject = new JsonParser().parse(storeJson).getAsJsonObject();

        JsonArray arr = jsonObject.getAsJsonArray("items");
        
        for (int i = 0; i < arr.size(); i++) {
            String link = arr.get(i).getAsJsonObject().get("link").getAsString();
            imageResultURLs.add(link);
        }
        
	}

	public static void main (String args []) {
		ImagesRequest ir = new ImagesRequest("chicken");
	}

}
