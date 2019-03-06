package edu.usc.cs310.proj1.objects;
import java.util.ArrayList;
/**
 * @author karti
 *
 */
public class User {
	public ArrayList<Restaurant> favoriteRestaurant;
	public ArrayList<Recipe> favoriteRecipe;
	public ArrayList<Restaurant> exploreRestaurant;
	public ArrayList<Recipe> exploreRecipe;
	public ArrayList<Restaurant> notRestaurant;
	public ArrayList<Recipe> notRecipe;
	public SearchResult searchResult;
	public String check;
	
	public User() {
		favoriteRestaurant = new ArrayList<Restaurant>();
		exploreRestaurant = new ArrayList<Restaurant>();
		notRestaurant = new ArrayList<Restaurant>();
		favoriteRecipe = new ArrayList<Recipe>();
		exploreRecipe= new ArrayList<Recipe>();
		notRecipe = new ArrayList<Recipe>();
	}
	
	public void query(String q, int i, ArrayList<Restaurant> res, ArrayList<Recipe> rec, ArrayList<String> img ) {
		searchResult = new SearchResult();
		searchResult.searchTerm = q;
		searchResult.numItems = i;
		searchResult.restaurantResults = res;
		searchResult.recipeResults = rec;
	}
	
	public boolean addRestaurant(Restaurant i, String list) {
		check = "Restaurant";
		
		if(list.equals("favorite")) {
			check = "in";
			favoriteRestaurant.add(i);
		}
		else if(list.equals("explore")) {
			exploreRestaurant.add(i);
		}
		else if(list.equals("not")) {
			notRestaurant.add(i);
		}
		
		return true;
	}
	
	public boolean addRecipe(Recipe i, String list) {
		check = "Recipe";
		
		if(list.equals("favorite")) {
			favoriteRecipe.add(i);
		}
		else if(list.equals("explore")) {
			exploreRecipe.add(i);
		}
		else if(list.equals("not")) {
			notRecipe.add(i);
		}
		
		return true;
	}
	
	
	public boolean moveTo(Item i, String list1, String list2) {
		return true; //only if successfully transferred
	}
	

}
