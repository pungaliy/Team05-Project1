import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import edu.usc.cs310.proj1.objects.Restaurant;
import edu.usc.cs310.proj1.objects.YelpRequest;

/*
 * Tests to write:
 * 	Return values:
	 * -invalid query return blank array
	 * -valid query get length needed
	 * -valid query get all values populated
 * Paste in values:
 *  -invalid query 
 *  -query with spaces
 *  -case sensitive searches
 *  -search cuisine
 *  -search restaurant
 *  ___________________________
 *  ADD TO MAVEN:
 *  <dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.12</version>
</dependency>
source: https://www.vogella.com/tutorials/JUnit/article.html
 */



class YelpRequestTest {
	public int limit = 5;

	//QUERY TESTS
	@Test
	void failQuery() {
		String query = "~)(*"; 
		YelpRequest y = new YelpRequest(query,limit);
		System.out.println(y.restaurantResults.size());
		assertEquals(y.restaurantResults.size(),0);
	}
	@Test
	void goodQuery() {
		String query = "hamburgers"; 
		YelpRequest y = new YelpRequest(query,limit);
		System.out.println(y.restaurantResults);

		assertEquals(y.restaurantResults.size(),limit);
	}
	@Test
	void spaceQuery() {
		String query = "hamburger food"; 
		YelpRequest y = new YelpRequest(query,limit);
		System.out.println(y.restaurantResults.size());

		assertEquals(y.restaurantResults.size(),limit);
	}
	@Test
	void cuisineQuery() {
		String query = "indian"; 
		YelpRequest y = new YelpRequest(query,limit);
		System.out.println(y.restaurantResults.size());

		assertEquals(y.restaurantResults.size(),limit);		
	}
	@Test
	void restaurantQueryFull() {
		String query = "Starbucks"; 
		YelpRequest y = new YelpRequest(query,limit);
		System.out.println(y.restaurantResults.size());

		assertEquals(y.restaurantResults.size(),limit);		
	}	
	@Test
	void restaurantQueryValid() {
		String query = "Starbucks"; 
		YelpRequest y = new YelpRequest(query,limit);
		System.out.println(y.restaurantResults.get(0).name);
		//query should return Starbucks nearby 
		assertEquals(y.restaurantResults.get(0).name,"Starbucks");	
	}
	@Test
	void findWebsite() {
		String query = "burger"; 
		YelpRequest y = new YelpRequest(query,limit);
		System.out.println(y.restaurantResults.size());
		//query should return Starbucks nearby 
		System.out.println(y.restaurantResults.get(0).websiteLink);
		assertEquals(y.restaurantResults.get(0).websiteLink,"usctraditions.com");	
	}
	
	@Test
	void distanceCheck() {
		String query = "burger"; 
		YelpRequest y = new YelpRequest(query,limit);
		System.out.println(y.restaurantResults.size());
		//query should return Starbucks nearby 
		System.out.println(y.restaurantResults.get(0).websiteLink);
		assertEquals(y.restaurantResults.get(0).travelTime,"1 min");	
	}
	//Return Value Tests
	@Test
	void fullPopulated () {
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
	void caseSensitive () {
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
