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
	
	
	public boolean moveRecipe(String firstList, String endList, int index) {
		check = "moveRecipe";
		if(firstList.equals("favorite")) {
			Recipe r = favoriteRecipe.get(index);
			
					if(endList.equals("explore")) {
						exploreRecipe.add(r);
					}
					else if(endList.equals("not")) {
						notRecipe.add(r);
					}
			favoriteRecipe.remove(index);
			return true;
			
		}
		else if(firstList.equals("explore")) {
			
			Recipe r = exploreRecipe.get(index);
					if(endList.equals("favorite")) {
						favoriteRecipe.add(r);
						
					}
					else if(endList.equals("not")) {
						notRecipe.add(r);
						
					}
			exploreRecipe.remove(index);
			return true;
	
		}
		else if(firstList.equals("not")) {
			
			Recipe r = notRecipe.get(index);
			
					if(endList.equals("explore")) {
						exploreRecipe.add(r);
						
					}
					else if(endList.equals("favorite")) {
						favoriteRecipe.add(r);
						
					}
			notRecipe.remove(index);
			return true;

		}
		return false;
	}
	
	public boolean moveRestaurant(String firstList, String endList, int index) {
		check = "moveRestaurant";
		if(firstList.equals("favorite")) {
			
			Restaurant r = favoriteRestaurant.get(index);
			
					if(endList.equals("explore")) {
						exploreRestaurant.add(r);
						
					}
					else if(endList.equals("not")) {
						notRestaurant.add(r);
						
					}
					favoriteRestaurant.remove(index);
					return true;
			
		}
		else if(firstList.equals("explore")) {
			Restaurant r = exploreRestaurant.get(index);
					if(endList.equals("favorite")) {
						favoriteRestaurant.add(r);
						
					}
					else if(endList.equals("not")) {
						notRestaurant.add(r);
						
					}
					exploreRestaurant.remove(index);
					return true;
	
		}
		else if(firstList.equals("not")) {
			
			Restaurant r = notRestaurant.get(index);
					if(endList.equals("explore")) {
						exploreRestaurant.add(r);
						
					}
					else if(endList.equals("favorite")) {
						favoriteRestaurant.add(r);
						
					}
			notRestaurant.remove(index);
			return true;
	
		}
		return false;
	}
	
	public void removeRestaurant(String list, int index) {
		check = "removeRes";
		if(list.equals("favorite")) {
					favoriteRestaurant.remove(index);

		}
		else if(list.equals("explore")) {
					exploreRestaurant.remove(index);
			
		}
		else if(list.equals("not")) {
					notRestaurant.remove(index);
		}
	}
	
	public void removeRecipe(String list, int index) {
		check = "removeRec";
		if(list.equals("favorite")) {
					favoriteRecipe.remove(index);
		}
		else if(list.equals("explore")) {
					exploreRecipe.remove(index);

		}
		else if(list.equals("not")) {
					notRecipe.remove(index);
		}
	}
	

}
