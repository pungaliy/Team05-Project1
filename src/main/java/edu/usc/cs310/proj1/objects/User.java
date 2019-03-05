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
	
	public void query(String q, int i, ArrayList<Restaurant> res, ArrayList<Recipe> rec, ArrayList<String> img ) {
		searchResult = new SearchResult();
		searchResult.searchTerm = q;
		searchResult.numItems = i;
		searchResult.restaurantResults = res;
		searchResult.recipeResults = rec;
	}
	
	
	public boolean moveTo(Item i, String list1, String list2) {
		return true; //only if successfully transferred
	}
	

}
