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
	
	
	public boolean moveRecipe(String firstList, String endList, String name) {
		if(firstList == "favorite") {
			for(Recipe r: favoriteRecipe) {
				if(r.recipeName == name) {
					r.isFavorite = false;
					if(endList == "explore") {
						exploreRecipe.add(r);
						r.isToExplore = true;
					}
					else if(endList == "not") {
						notRecipe.add(r);
						r.isDoNotExplore = true;
					}
					favoriteRecipe.remove(r);
					return true;
				}
			}
		}
		else if(firstList == "explore") {
			for(Recipe r: exploreRecipe) {
				if(r.recipeName == name) {
					r.isToExplore = false;
					if(endList == "favorite") {
						favoriteRecipe.add(r);
						r.isFavorite = true;
					}
					else if(endList == "not") {
						notRecipe.add(r);
						r.isDoNotExplore = true;
					}
					exploreRecipe.remove(r);
					return true;
				}
			}
		}
		else if(firstList == "not") {
			for(Recipe r: notRecipe) {
				if(r.recipeName == name) {
					r.isDoNotExplore = false;
					if(endList == "explore") {
						exploreRecipe.add(r);
						r.isToExplore = true;
					}
					else if(endList == "favorite") {
						favoriteRecipe.add(r);
						r.isFavorite = true;
					}
					notRecipe.remove(r);
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean moveRestaurant(String firstList, String endList, String name) {
		if(firstList == "favorite") {
			for(Restaurant r: favoriteRestaurant) {
				if(r.thisName == name) {
					r.isFavorite = false;
					if(endList == "explore") {
						exploreRestaurant.add(r);
						r.isToExplore = true;
					}
					else if(endList == "not") {
						notRestaurant.add(r);
						r.isDoNotExplore = true;
					}
					favoriteRestaurant.remove(r);
					return true;
				}
			}
		}
		else if(firstList == "explore") {
			for(Restaurant r: exploreRestaurant) {
				if(r.thisName == name) {
					r.isToExplore = false;
					if(endList == "favorite") {
						favoriteRestaurant.add(r);
						r.isFavorite = true;
					}
					else if(endList == "not") {
						notRestaurant.add(r);
						r.isDoNotExplore = true;
					}
					exploreRestaurant.remove(r);
					return true;
				}
			}
		}
		else if(firstList == "not") {
			for(Restaurant r: notRestaurant) {
				if(r.thisName == name) {
					r.isDoNotExplore = false;
					if(endList == "explore") {
						exploreRestaurant.add(r);
						r.isToExplore = true;
					}
					else if(endList == "favorite") {
						favoriteRestaurant.add(r);
						r.isFavorite = true;
					}
					notRestaurant.remove(r);
					return true;
				}
			}
		}
		return false;
	}
	

}
