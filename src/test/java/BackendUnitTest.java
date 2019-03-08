import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Test;

import edu.usc.cs310.proj1.objects.Restaurant;
import edu.usc.cs310.proj1.objects.User;
import edu.usc.cs310.proj1.objects.YelpRequest;
import edu.usc.cs310.proj1.objects.ImagesRequest;
import edu.usc.cs310.proj1.objects.Recipe;
import edu.usc.cs310.proj1.objects.RecipeRequest;


public class BackendUnitTest {
	
	public int limit = 5;

	//RECIPE TESTS
	@Test
	public void failQuery() {
		String query = "~)(*"; 
		RecipeRequest y = new RecipeRequest(query,limit);
		assertEquals(y.recipeResults.size(),0);
	}
	@Test
	public void goodQuery() {
		String query = "hamburger"; 
		RecipeRequest y = new RecipeRequest(query,limit);
		assertEquals(y.recipeResults.size(),limit);
	}
	
	@Test
	public void size1Query() {
		String query = "hamburger"; 
		RecipeRequest y = new RecipeRequest(query,1);
		assertEquals(y.recipeResults.size(),1);
	}
	
	@Test
	public void size2Query() {
		String query = "hamburger"; 
		RecipeRequest y = new RecipeRequest(query,2);
		assertEquals(y.recipeResults.size(),2);
	}
	
	@Test
	public void size3Query() {
		String query = "hamburger"; 
		RecipeRequest y = new RecipeRequest(query,3);
		assertEquals(y.recipeResults.size(),3);
	}
	
	@Test
	public void size4Query() {
		String query = "hamburger"; 
		RecipeRequest y = new RecipeRequest(query,4);
		assertEquals(y.recipeResults.size(),4);
	}
	
	@Test
	public void spaceQuery() {
		String query = "hamburger food"; 
		RecipeRequest y = new RecipeRequest(query,limit);
		assertEquals(y.recipeResults.size(),limit);
		
		try {
			Thread.sleep(1250);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Test
	public void cuisineQuery() {
		String query = "chinese"; 
		RecipeRequest y = new RecipeRequest(query, 1);
		assertEquals(y.recipeResults.size(), 1);
	}
	
	@Test
	public void popularQuery() {
		String query = "burger"; 
		RecipeRequest y = new RecipeRequest(query,3);
		assertEquals(y.recipeResults.size(),3);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void unpopularQuery() {
		String query = "u"; 
		RecipeRequest y = new RecipeRequest(query,5);
		assertEquals(y.recipeResults.size(),2);
		
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//YELP REQUEST TESTS
	@Test
	public void failQueryRest() {
		String query = "~)(*"; 
		YelpRequest y = new YelpRequest(query,limit);
		assertEquals(y.restaurantResults.size(),0);
	}
	@Test
	public void goodQueryRest() {
		String query = "hamburgers"; 
		YelpRequest y = new YelpRequest(query,limit);

		assertEquals(y.restaurantResults.size(),limit);
	}
	@Test
	public void spaceQueryRest() {
		String query = "hamburger food"; 
		YelpRequest y = new YelpRequest(query,limit);

		assertEquals(y.restaurantResults.size(),limit);
	}
	@Test
	public void cuisineQueryRest() {
		String query = "indian"; 
		YelpRequest y = new YelpRequest(query,limit);

		assertEquals(y.restaurantResults.size(),limit);		
	}
	@Test
	public void restaurantQueryFull() {
		String query = "Starbucks"; 
		YelpRequest y = new YelpRequest(query,limit);

		assertEquals(y.restaurantResults.size(),limit);		
	}	
	@Test
	public void restaurantQueryValid() {
		String query = "Starbucks"; 
		YelpRequest y = new YelpRequest(query,limit);
		//query should return Starbucks nearby 
		assertEquals(y.restaurantResults.get(0).name,"Starbucks");	
	}
	@Test
	public void findWebsite() {
		String query = "burger"; 
		YelpRequest y = new YelpRequest(query,limit);
		//query should return Starbucks nearby 
		assertEquals(y.restaurantResults.get(0).websiteLink,"usctraditions.com");	
	}
	
	@Test
	public void distanceCheck() {
		String query = "burger"; 
		YelpRequest y = new YelpRequest(query,limit);
		//query should return Starbucks nearby 
		assertEquals(y.restaurantResults.get(0).travelTime,"1 min");	
	}
	//Return Value Tests
	@Test
	public void fullPopulated () {
		String query = "hamburger";
		YelpRequest y = new YelpRequest(query,limit);
		for(int i = 0; i < y.restaurantResults.size();i++) {
			Restaurant s = y.restaurantResults.get(i);
			//make sure all attributes have values
			assertNotNull(s.name);
			assertNotNull(s.websiteLink);
			assertNotNull(s.price);
			assertNotNull(s.distance);
			assertNotNull(s.uniqueID);
			assertNotNull(s.rating);
			assertNotNull(s.address);
			assertNotNull(s.googleMapsLink);
		}
	}
	
	@Test
	public void caseSensitive () {
		String query = "HamBurger";
		YelpRequest y = new YelpRequest(query,limit);
		for(int i = 0; i < y.restaurantResults.size();i++) {
			Restaurant s = y.restaurantResults.get(i);
			//make sure all attributes have values
			assertNotNull(s.name);
			assertNotNull(s.websiteLink);
			assertNotNull(s.price);
			assertNotNull(s.distance);
			assertNotNull(s.uniqueID);
			assertNotNull(s.rating);
			assertNotNull(s.address);
			assertNotNull(s.googleMapsLink);
		}
	}
	
	//USER Object Tests
	
	@Test
	public void addRecipeFavorite() {
		User u = new User ();
		Recipe r = new Recipe("name","imagelink","prep","cooktime", new ArrayList<String>(), new ArrayList<String>(),"q",2.0);
		r.name = "name";
		u.addRecipe(r, "favorite");
		assertEquals(u.favoriteRecipe.get(0).name,"name");
	}
	
	@Test
	public void addRecipeToExplore() {
		User u = new User ();
		Recipe r = new Recipe("name","imagelink","prep","cooktime", new ArrayList<String>(), new ArrayList<String>(),"q",2.0);
		r.name = "name";
		u.addRecipe(r, "explore");
		assertEquals(u.exploreRecipe.get(0).name,"name");
	}
	
	@Test
	public void addRecipeNotShow() {
		User u = new User ();
		Recipe r = new Recipe("name","imagelink","prep","cooktime", new ArrayList<String>(), new ArrayList<String>(),"q",2.0);
		r.name = "name";
		u.addRecipe(r, "not");
		assertEquals(u.notRecipe.get(0).name,"name");
	}
	
	@Test
	public void addRestaurantFavorite () {
		User u = new User ();
		Restaurant r = new Restaurant();
		r.name= "name";
		u.addRestaurant(r, "favorite");
		assertEquals(u.favoriteRestaurant.get(0).name,"name");
	}
	@Test
	public void addRestaurantToExplore () {
		User u = new User ();
		Restaurant r = new Restaurant();
		r.name= "name";
		u.addRestaurant(r, "explore");
		assertEquals(u.exploreRestaurant.get(0).name,"name");
	}
	@Test
	public void addRestaurantDoNotShow () {
		User u = new User ();
		Restaurant r = new Restaurant();
		r.name= "name";
		u.addRestaurant(r, "not");
		assertEquals(u.notRestaurant.get(0).name,"name");
	}
	
	
	@Test
	public void removeRecipeFavorite() {
		User u = new User ();
		Recipe r = new Recipe("name","imagelink","prep","cooktime", new ArrayList<String>(), new ArrayList<String>(),"q",2.0);
		u.addRecipe(r, "favorite");
		u.removeRecipe("favorite", 0);
		assertEquals(u.favoriteRecipe.size(),0);
	}
	
	@Test
	public void removeRecipeToExplore() {
		User u = new User ();
		Recipe r = new Recipe("name","imagelink","prep","cooktime", new ArrayList<String>(), new ArrayList<String>(),"q",2.0);
		u.addRecipe(r, "explore");
		u.removeRecipe("explore",0);
		assertEquals(u.exploreRecipe.size(),0);
	}
	
	@Test
	public void removeRecipeNotShow() {
		User u = new User ();
		Recipe r = new Recipe("name","imagelink","prep","cooktime", new ArrayList<String>(), new ArrayList<String>(),"q",2.0);
		u.addRecipe(r, "not");
		u.removeRecipe("not", 0);
		assertEquals(u.notRecipe.size(),0);
	}
	
	@Test
	public void removeRestaurantFavorite () {
		User u = new User ();
		Restaurant r = new Restaurant();
		r.name= "name";
		u.addRestaurant(r, "favorite");
		u.removeRestaurant("favorite", 0);
		assertEquals(u.favoriteRestaurant.size(),0);
	}
	@Test
	public void removeRestaurantToExplore () {
		User u = new User ();
		Restaurant r = new Restaurant();
		r.name= "name";
		u.addRestaurant(r, "explore");
		u.removeRestaurant("explore", 0);
		assertEquals(u.exploreRestaurant.size(),0);
	}
	@Test
	public void removeRestaurantDoNotShow () {
		User u = new User ();
		Restaurant r = new Restaurant();
		r.name= "name";
		u.addRestaurant(r, "not");
		u.removeRestaurant("not",0);
		assertEquals(u.notRestaurant.size(),0);
	}
	
	@Test
	public void moveRecipeFavorite_to_DoNotShow() {
		User u = new User ();
		Recipe r = new Recipe("name","imagelink","prep","cooktime", new ArrayList<String>(), new ArrayList<String>(),"q",2.0);
		r.name = "name";
		u.addRecipe(r, "favorite");
		u.moveRecipe("favorite","not", 0);
		assertEquals(u.notRecipe.get(0).name,"name");
	}
	@Test
	public void moveRecipeFavorite_to_Explore() {
		User u = new User ();
		Recipe r = new Recipe("name","imagelink","prep","cooktime", new ArrayList<String>(), new ArrayList<String>(),"q",2.0);
		r.name = "name";
		u.addRecipe(r, "favorite");
		u.moveRecipe("favorite","explore", 0);
		assertEquals(u.exploreRecipe.get(0).name,"name");
	}
	
	@Test
	public void moveRecipeToExplore_to_Favorite() {
		User u = new User ();
		Recipe r = new Recipe("name","imagelink","prep","cooktime", new ArrayList<String>(), new ArrayList<String>(),"q",2.0);
		r.name = "name";
		u.addRecipe(r, "explore");
		u.moveRecipe("explore", "favorite", 0);
		assertEquals(u.favoriteRecipe.get(0).name,"name");
	}
	@Test
	public void moveRecipeToExplore_to_DoNotShow() {
		User u = new User ();
		Recipe r = new Recipe("name","imagelink","prep","cooktime", new ArrayList<String>(), new ArrayList<String>(),"q",2.0);
		r.name = "name";
		u.addRecipe(r, "explore");
		u.moveRecipe("explore", "not", 0);
		assertEquals(u.notRecipe.get(0).name,"name");
	}
	
	@Test
	public void moveRecipeNotShow_to_Favorite() {
		User u = new User ();
		Recipe r = new Recipe("name","imagelink","prep","cooktime", new ArrayList<String>(), new ArrayList<String>(),"q",2.0);
		r.name = "name";
		u.addRecipe(r, "not");
		u.moveRecipe("not","favorite", 0);
		assertEquals(u.favoriteRecipe.get(0).name,"name");
	}
	@Test
	public void moveRecipeNotShow_to_Explore() {
		User u = new User ();
		Recipe r = new Recipe("name","imagelink","prep","cooktime", new ArrayList<String>(), new ArrayList<String>(),"q",2.0);
		r.name = "name";
		u.addRecipe(r, "not");
		u.moveRecipe("not","explore", 0);
		assertEquals(u.exploreRecipe.get(0).name,"name");
	}
	
	@Test
	public void moveRestaurantDoNotShow_to_Favorite () {
		User u = new User ();
		Restaurant r = new Restaurant();
		r.name= "name";
		u.addRestaurant(r, "not");
		u.moveRestaurant("not", "favorite", 0);
		assertEquals(u.favoriteRestaurant.get(0).name,"name");
	}
	@Test
	public void moveRestaurantDoNotShow_to_explore () {
		User u = new User ();
		Restaurant r = new Restaurant();
		r.name= "name";
		u.addRestaurant(r, "not");
		u.moveRestaurant("not", "explore", 0);
		assertEquals(u.exploreRestaurant.get(0).name,"name");
	}
	@Test
	public void moveRestaurantToExplore_to_Favorite () {
		User u = new User ();
		Restaurant r = new Restaurant();
		r.name= "name";
		u.addRestaurant(r, "explore");
		u.moveRestaurant("explore", "favorite", 0);
		assertEquals(u.favoriteRestaurant.get(0).name,"name");
	}
	@Test
	public void moveRestaurantToExplore_to_DoNotShow() {
		User u = new User ();
		Restaurant r = new Restaurant();
		r.name= "name";
		u.addRestaurant(r, "explore");
		u.moveRestaurant("explore", "not", 0);
		assertEquals(u.notRestaurant.get(0).name,"name");
	}	
	@Test
	public void moveRestaurantFavorite_to_DoNotShow () {
		User u = new User ();
		Restaurant r = new Restaurant();
		r.name= "name";
		u.addRestaurant(r, "favorite");
		u.moveRestaurant("favorite", "not", 0);
		assertEquals(u.notRestaurant.get(0).name,"name");
	}
	@Test
	public void moveRestaurantFavorite_to_Explore () {
		User u = new User ();
		Restaurant r = new Restaurant();
		r.name= "name";
		u.addRestaurant(r, "favorite");
		u.moveRestaurant("favorite", "explore", 0);
		assertEquals(u.exploreRestaurant.get(0).name,"name");
	}	
	
	@Test
	public void moveFalseRestaurant() {
		User u = new User ();
		assertFalse(u.moveRestaurant("nota", "asdf", 2));
	}
	@Test
	public void moveFalseRecipe() {
		User u = new User ();
		assertFalse(u.moveRecipe("nota", "asdf", 2));
	}
	
	//IMAGE REQUEST TESTS
	
	@Test
	public void imageRequestSize() {
		String query = "hamburger";
		ImagesRequest ir = new ImagesRequest(query);
		ArrayList<String> imageResults = new ArrayList<String>();
		imageResults = ir.imageResultURLs;
		assertEquals(imageResults.size(), 10);	
	}
	
	@Test
	public void imageRequestOtherQuery() {
		String query = "chicken";
		ImagesRequest ir = new ImagesRequest(query);
		ArrayList<String> imageResults = new ArrayList<String>();
		imageResults = ir.imageResultURLs;
		assertEquals(imageResults.size(), 10);	
	}

}
