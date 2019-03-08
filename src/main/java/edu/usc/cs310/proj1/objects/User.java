package edu.usc.cs310.proj1.objects;
import java.util.ArrayList;
/**
 * @author karti
 *
 */
public class User {
	//users lists management
	public ArrayList<Restaurant> favoriteRestaurant;
	public ArrayList<Recipe> favoriteRecipe;
	public ArrayList<Restaurant> exploreRestaurant;
	public ArrayList<Recipe> exploreRecipe;
	public ArrayList<Restaurant> notRestaurant;
	public ArrayList<Recipe> notRecipe;
	
	
	
	public User() {
		favoriteRestaurant = new ArrayList<Restaurant>();
		exploreRestaurant = new ArrayList<Restaurant>();
		notRestaurant = new ArrayList<Restaurant>();
		favoriteRecipe = new ArrayList<Recipe>();
		exploreRecipe= new ArrayList<Recipe>();
		notRecipe = new ArrayList<Recipe>();
	}

	//add restaurant item to the list
	public boolean addRestaurant(Restaurant i, String list) {	
		//check which list to add restaurant to
		if(list.equals("favorite")) {
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
	
	//check recipe item to the list
	public boolean addRecipe(Recipe i, String list) {
		//check which list to add recipe to
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
	
	
	//moving recipe items from one list to another
	public boolean moveRecipe(String firstList, String endList, int index) {
		//check which list it comes from
		if(firstList.equals("favorite")) {
			Recipe r = favoriteRecipe.get(index);
			//checks to which list it should sent to
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
			//to check which list it should sent to
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
			//check which list it should sent to
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
	
	//to move restaurant items to another list
	public boolean moveRestaurant(String firstList, String endList, int index) {
		//check which list it comes from 
		if(firstList.equals("favorite")) {
			//check which list it should move to
			Restaurant r = favoriteRestaurant.get(index);
			if(endList.equals("explore")) {
				exploreRestaurant.add(r);
				
			}
			else if(endList.equals("not")) {
				notRestaurant.add(r);
				return false;
			}
			favoriteRestaurant.remove(index);
			return true;
			
		}
		else if(firstList.equals("explore")) {
			//check which list it should move to
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
			//check which list it should move to
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
	
	//remove restaurant items from the list
	public void removeRestaurant(String list, int index) {
		//check which list to remove from
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
	
	//remove recipe items from the list
	public void removeRecipe(String list, int index) {
		//check which list to remove from
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
