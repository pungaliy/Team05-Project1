package edu.usc.cs310.proj1.objects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

/*   -----README-----

Notes on Yelp API:
	Full Documentation at: https://www.yelp.com/developers/documentation/v3
	Implementation based on: https://www.yelp.com/developers/documentation/v3/business_search

Dependencies used + download links:
jsonObject jar: DOWNLOAD AT - https://mvnrepository.com/artifact/org.json/json/20180813


*/
public class YelpRequest {
	//Yelp API specific
	public String clientID = "bmHLHijF54gd6VYAmCRgpg";
	public String API_KEY = "rQ5uNphuvuAYuCeOb6UE27wKAstk_l8mar7oRkJViakWRkRekoQ6nB9GuxTP-Ll6soPa7is_j4dyxTufUDKbHvzZ30UwoNpUwk6UBY8SCzv2sXuZj6INml2_9PtxXHYx";
	
	//General 
	public String appName = "I'm Hungry";
	
	//needed to send in get request
	public String term = "";
	public String location = "USC";
	public double latitude = 34.0206; //based on location of Tommy Trojan
	public double longitude = -118.2854;
	public int radius = 15000; // about a 10 mile radius
	public String categories = ""; //specify if cuisine. Format "onetwothree" [no spaces]
	public int limit = 5; //recieve from search result
	public String sort_by = "distance";
	public boolean isCategory = false;
	
	//general request format
	public String HOST_URL = "https://api.yelp.com";
	public String SEARCH_PATH = "/v3/businesses/search";
	public String CUSTOM_PATH = "/v3/businesses/";
	
	//hold the main result
	public ArrayList<Restaurant> restaurantResults = new ArrayList<>();
	public YelpRequest(String query, int numItems, boolean isCategory) {
		this.term = query;
		this.limit = numItems;
		this.isCategory = isCategory;
	}
	public YelpRequest(String query, int numItems) {
		this.term = query;
		this.limit = numItems;
	}
	public void request () throws IOException {
		//set up
		String url = HOST_URL + SEARCH_PATH;
		url += "?sort_by=" + sort_by;
		url = addParameter(url,"longitude",this.longitude + "");
		url = addParameter(url,"latitude",this.latitude + "");
		url = addParameter(url,"limit",this.limit + "");
		url = addParameter(url,"term",this.term);
		
		//establish connection
		URL yelp = new URL(url);
		HttpURLConnection conn = (HttpURLConnection) yelp.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Authorization","Bearer "+  API_KEY);
		
		if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
			//means connection set
			BufferedReader in = new BufferedReader(
					  new InputStreamReader(conn.getInputStream()));
					String inputLine;
					StringBuffer content = new StringBuffer();
					while ((inputLine = in.readLine()) != null) {
					    content.append(inputLine);
					}
		
					addToList(content.toString());
					in.close();		
			}else {
				//debug info
				System.out.println("Connection failed to ");
				System.out.println(yelp.toString());
				System.out.println(conn.toString());
				System.out.println(conn.getResponseCode());
			}
		
		
	}
	
	public void addToList(String s) {
		JSONObject jsonObj = new JSONObject(s);
		JSONArray contents;
		if (jsonObj.has("businesses")) {
			 contents = jsonObj.getJSONArray("businesses");
		} else {
			System.out.println("no results");
			return;
		}
		for(int i= 0; i < contents.length(); i++) {
			JSONObject res = contents.getJSONObject(i);
			Restaurant r = new Restaurant();
			r.name = res.getString("name");
			r.websiteLink = res.getString("url"); 
			r.uniqueID = res.getString("id");
			if (res.has("price")) {
				r.price = res.getString("price");			
			}
			r.address = parseAddress(res.getJSONObject("location"));
			if (res.has("rating")) {
				r.rating = res.getDouble("rating");			
			}			
			r.phoneNumber = res.getString("phone");
			r.distance = res.getDouble("distance");
			this.restaurantResults.add(r);
//			System.out.println(res.toString());
		}

	}
	public String parseAddress (JSONObject a) {
		JSONArray add = a.getJSONArray("display_address");
		return (add.get(0) + ", "+ add.get(1));
	}
	
	public String addParameter (String URL, String param, String paramValue) {
		return (URL + "&" + param + "=" + paramValue);
	}
	
	public static void main (String args []) {
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("What would you like to search?");
			String query = scan.nextLine();
			System.out.println("How many search results?");
			int options = scan.nextInt();
			scan.nextLine();
			YelpRequest y = new YelpRequest(query, options);
			try {
				y.request();
				System.out.println("[1]normal or [2]pretty print? [type 1 for normal]");
				String choice = scan.nextLine();
				System.out.println(y.restaurantResults.size() + " results shown:");
				if (choice.equalsIgnoreCase("1")) {
					for(int i = 0; i < y.restaurantResults.size(); i++) {
						System.out.println(i+1 + ". " + y.restaurantResults.get(i));
					}
				}else {
					for(int i = 0; i < y.restaurantResults.size(); i++) {
						System.out.println(y.restaurantResults.get(i).prettyPrint());
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
	
	
}
