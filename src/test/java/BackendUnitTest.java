import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Test;

import edu.usc.cs310.proj1.objects.Restaurant;
import edu.usc.cs310.proj1.objects.YelpRequest;
import edu.usc.cs310.proj1.objects.ImagesRequest;
import edu.usc.cs310.proj1.objects.RecipeRequest;


public class BackendUnitTest {
	
	public int limit = 5;

	//RECIPE TESTS
	@Test
	public void failQuery() {
		String query = "~)(*"; 
		RecipeRequest y = new RecipeRequest(query,limit);
		System.out.println(y.recipeResults.size());
		assertEquals(y.recipeResults.size(),0);
	}
	@Test
	public void goodQuery() {
		String query = "hamburger"; 
		RecipeRequest y = new RecipeRequest(query,limit);
		System.out.println(y.recipeResults.size());
		assertEquals(y.recipeResults.size(),limit);
	}
	
	@Test
	public void size1Query() {
		String query = "hamburger"; 
		RecipeRequest y = new RecipeRequest(query,1);
		System.out.println(y.recipeResults.size());
		assertEquals(y.recipeResults.size(),1);
	}
	
	@Test
	public void size2Query() {
		String query = "hamburger"; 
		RecipeRequest y = new RecipeRequest(query,2);
		System.out.println(y.recipeResults.size());
		assertEquals(y.recipeResults.size(),2);
	}
	
	@Test
	public void size3Query() {
		String query = "hamburger"; 
		RecipeRequest y = new RecipeRequest(query,3);
		System.out.println(y.recipeResults.size());
		assertEquals(y.recipeResults.size(),3);
	}
	
	@Test
	public void size4Query() {
		String query = "hamburger"; 
		RecipeRequest y = new RecipeRequest(query,4);
		System.out.println(y.recipeResults.size());
		assertEquals(y.recipeResults.size(),4);
	}
	
	@Test
	public void spaceQuery() {
		String query = "hamburger food"; 
		RecipeRequest y = new RecipeRequest(query,limit);
		System.out.println(y.recipeResults.size());
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
		System.out.println(y.recipeResults.size());
		assertEquals(y.recipeResults.size(), 1);
	}
	
	@Test
	public void popularQuery() {
		String query = "burger"; 
		RecipeRequest y = new RecipeRequest(query,3);
		System.out.println(y.recipeResults.size());
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
		System.out.println(y.recipeResults.size());
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
		System.out.println(y.restaurantResults.size());
		assertEquals(y.restaurantResults.size(),0);
	}
	@Test
	public void goodQueryRest() {
		String query = "hamburgers"; 
		YelpRequest y = new YelpRequest(query,limit);
		System.out.println(y.restaurantResults);

		assertEquals(y.restaurantResults.size(),limit);
	}
	@Test
	public void spaceQueryRest() {
		String query = "hamburger food"; 
		YelpRequest y = new YelpRequest(query,limit);
		System.out.println(y.restaurantResults.size());

		assertEquals(y.restaurantResults.size(),limit);
	}
	@Test
	public void cuisineQueryRest() {
		String query = "indian"; 
		YelpRequest y = new YelpRequest(query,limit);
		System.out.println(y.restaurantResults.size());

		assertEquals(y.restaurantResults.size(),limit);		
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
		System.out.println(y.restaurantResults.get(0).name);
		//query should return Starbucks nearby 
		assertEquals(y.restaurantResults.get(0).name,"Starbucks");	
	}
	@Test
	public void findWebsite() {
		String query = "burger"; 
		YelpRequest y = new YelpRequest(query,limit);
		System.out.println(y.restaurantResults.size());
		//query should return Starbucks nearby 
		System.out.println(y.restaurantResults.get(0).websiteLink);
		assertEquals(y.restaurantResults.get(0).websiteLink,"usctraditions.com");	
	}
	
	@Test
	public void distanceCheck() {
		String query = "burger"; 
		YelpRequest y = new YelpRequest(query,limit);
		System.out.println(y.restaurantResults.size());
		//query should return Starbucks nearby 
		System.out.println(y.restaurantResults.get(0).websiteLink);
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
	
	//IMAGES REQUEST
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