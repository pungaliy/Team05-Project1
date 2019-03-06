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
		if(firstList.equals("favorite")) {
			for(Recipe r: favoriteRecipe) {
				if(r.recipeName.equals(name)) {
					r.isFavorite = false;
					if(endList.equals("explore")) {
						exploreRecipe.add(r);
						r.isToExplore = true;
					}
					else if(endList.equals("not")) {
						notRecipe.add(r);
						r.isDoNotExplore = true;
					}
					favoriteRecipe.remove(r);
					return true;
				}
			}
		}
		else if(firstList.equals("explore")) {
			for(Recipe r: exploreRecipe) {
				if(r.recipeName.equals(name)) {
					r.isToExplore = false;
					if(endList.equals("favorite")) {
						favoriteRecipe.add(r);
						r.isFavorite = true;
					}
					else if(endList.equals("not")) {
						notRecipe.add(r);
						r.isDoNotExplore = true;
					}
					exploreRecipe.remove(r);
					return true;
				}
			}
		}
		else if(firstList.equals("not")) {
			for(Recipe r: notRecipe) {
				if(r.recipeName.equals(name)) {
					r.isDoNotExplore = false;
					if(endList.equals("explore")) {
						exploreRecipe.add(r);
						r.isToExplore = true;
					}
					else if(endList.equals("favorite")) {
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
		if(firstList.equals("favorite")) {
			for(Restaurant r: favoriteRestaurant) {
				if(r.thisName.equals(name)) {
					r.isFavorite = false;
					if(endList.equals("explore")) {
						exploreRestaurant.add(r);
						r.isToExplore = true;
					}
					else if(endList.equals("not")) {
						notRestaurant.add(r);
						r.isDoNotExplore = true;
					}
					favoriteRestaurant.remove(r);
					return true;
				}
			}
		}
		else if(firstList.equals("explore")) {
			for(Restaurant r: exploreRestaurant) {
				if(r.thisName.equals(name)) {
					r.isToExplore = false;
					if(endList.equals("favorite")) {
						favoriteRestaurant.add(r);
						r.isFavorite = true;
					}
					else if(endList.equals("not")) {
						notRestaurant.add(r);
						r.isDoNotExplore = true;
					}
					exploreRestaurant.remove(r);
					return true;
				}
			}
		}
		else if(firstList.equals("not")) {
			for(Restaurant r: notRestaurant) {
				if(r.thisName.equals(name)) {
					r.isDoNotExplore = false;
					if(endList.equals("explore")) {
						exploreRestaurant.add(r);
						r.isToExplore = true;
					}
					else if(endList.equals("favorite")) {
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
	
	public void removeRestaurant(String list, String name) {
		if(list.equals("favorite")) {
			for(Restaurant r: favoriteRestaurant) {
				if(r.thisName.equals(name)) {
					r.isFavorite = false;
					favoriteRestaurant.remove(r);
				}
			}
		}
		else if(list.equals("explore")) {
			for(Restaurant r: exploreRestaurant) {
				if(r.thisName.equals(name)) {
					r.isToExplore = false;
					exploreRestaurant.remove(r);
				}
			}
		}
		else if(list.equals("not")) {
			for(Restaurant r: notRestaurant) {
				if(r.thisName.equals(name)) {
					r.isDoNotExplore = false;
					notRestaurant.remove(r);
				}
			}
		}
	}
	
	public void removeRecipe(String list, String name) {
		if(list.equals("favorite")) {
			for(Recipe r: favoriteRecipe) {
				if(r.recipeName.equals(name)) {
					r.isFavorite = false;
					favoriteRecipe.remove(r);
				}
			}
		}
		else if(list.equals("explore")) {
			for(Recipe r: exploreRecipe) {
				if(r.recipeName.equals(name)) {
					r.isToExplore = false;
					exploreRestaurant.remove(r);
				}
			}
		}
		else if(list.equals("not")) {
			for(Recipe r: notRecipe) {
				if(r.recipeName.equals(name)) {
					r.isDoNotExplore = false;
					notRestaurant.remove(r);
				}
			}
		}
	}
	

}
