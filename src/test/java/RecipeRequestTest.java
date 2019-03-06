import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

import edu.usc.cs310.proj1.objects.Restaurant;
import edu.usc.cs310.proj1.objects.YelpRequest;
import edu.usc.cs310.proj1.objects.RecipeRequest;


public class RecipeRequestTest {
	
	public int limit = 5;

	//QUERY TESTS
	@Test
	public void failQuery() {
		String query = "~)(*"; 
		RecipeRequest y = new RecipeRequest(query,limit);
		System.out.println(y.recipeResults.size());
		assertEquals(y.recipeResults.size(),0);
	}
	@Test
	public void goodQuery() {
		String query = "hamburgers"; 
		RecipeRequest y = new RecipeRequest(query,limit);
		System.out.println(y.recipeResults.size());
		assertEquals(y.recipeResults.size(),limit);
	}
	@Test
	public void spaceQuery() {
		String query = "hamburger food"; 
		RecipeRequest y = new RecipeRequest(query,limit);
		System.out.println(y.recipeResults.size());
		assertEquals(y.recipeResults.size(),limit);
	}
	@Test
	public void cuisineQuery() {
		String query = "indian"; 
		RecipeRequest y = new RecipeRequest(query,limit);
		System.out.println(y.recipeResults.size());
		assertEquals(y.recipeResults.size(),limit);
	}
	@Test
	public void restaurantQueryFull() {
		String query = "Starbucks"; 
		YelpRequest y = new YelpRequest(query,limit);
		System.out.println(y.restaurantResults.size());

		assertEquals(y.restaurantResults.size(),limit);		
	}	
	@Test
	public void restaurantQueryValid() {
		String query = "Starbucks"; 
		YelpRequest y = new YelpRequest(query,limit);
		System.out.println(y.restaurantResults.size());

		assertEquals(y.restaurantResults.get(0).name,"Starbucks");	
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
	
	


}