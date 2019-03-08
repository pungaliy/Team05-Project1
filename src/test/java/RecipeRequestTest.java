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
	
}