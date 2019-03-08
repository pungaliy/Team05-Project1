package edu.usc.cs310.proj1.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import edu.usc.cs310.proj1.objects.ImagesRequest;
import edu.usc.cs310.proj1.objects.Recipe;
import edu.usc.cs310.proj1.objects.RecipeRequest;
import edu.usc.cs310.proj1.objects.Restaurant;
import edu.usc.cs310.proj1.objects.User;
import edu.usc.cs310.proj1.objects.YelpRequest;

/**
 * Servlet implementation class searchUser
 */
@WebServlet("/ReturnResults")
public class ReturnResults extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReturnResults() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		//get parameters and user query
		String query = request.getParameter("query");
		String options = request.getParameter("options");	
		int numOptions = Integer.parseInt(options);
		
		User thisUser = new User();
        
		
		//check if the same search, then return the same results
		if(session.getAttribute("query") == null || !session.getAttribute("query").equals(query) || (session.getAttribute("query").equals(query) && (int)session.getAttribute("options") != numOptions)) {
			 
			//create new instances of Results
			ArrayList<Restaurant> restaurantResults = new ArrayList<Restaurant>();
			ArrayList<Recipe> recipeResults = new ArrayList<Recipe>();
			ArrayList<String> imageResults = new ArrayList<String>();
			
			//API Calls to get restaurant and recipe results
			YelpRequest y = new YelpRequest(query, numOptions);
			restaurantResults = y.restaurantResults;
			
			RecipeRequest r = new RecipeRequest(query, numOptions);
			recipeResults = r.recipeResults;
			
			//for testing purposes
			if(query.contentEquals("hamburger")) {
				imageResults.add("https://upload.wikimedia.org/wikipedia/commons/9/9a/Big_Mac_hamburger.jpg");
				imageResults.add("https://www.recipetineats.com/wp-content/uploads/2016/02/Beef-Hamburgers_7-2.jpg");
				imageResults.add("https://www.thespruceeats.com/thmb/ivY7T2DRygJN2nHwAFYqVxfbvs4=/3000x2000/filters:no_upscale():max_bytes(150000):strip_icc()/Hamburger-Hot-Dog-58add5f03df78c345bdef6ff.jpg");
				imageResults.add("data:image/jpeg;base64,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");
				imageResults.add("https://www.justataste.com/wp-content/uploads/2013/05/easy-homemade-parmesan-hamburger-buns-recipe.jpg");
				imageResults.add("https://www.saveur.com/sites/saveur.com/files/styles/1000_1x_/public/import/2014/2014-05/recipe_papas-favorite-wild-west-hamburger_i166_500x750.jpg?itok=QYuMyACp");
				imageResults.add("https://assets.epicurious.com/photos/57c5c6d9cf9e9ad43de2d96e/master/pass/the-ultimate-hamburger.jpg");
				imageResults.add("https://foremangrillrecipes.com/wp-content/uploads/2013/05/american-hamburger-foreman-grill.jpg");
				imageResults.add("https://cdn.vox-cdn.com/thumbor/rRLHMuiSwa6khLkqQg9gH-sGS30=/0x0:617x521/1200x800/filters:focal(320x235:418x333)/cdn.vox-cdn.com/uploads/chorus_image/image/59948629/hamburger_hamelet_facebook.0.png");
				imageResults.add("https://thumbor.forbes.com/thumbor/1280x868/https%3A%2F%2Fspecials-images.forbesimg.com%2Fdam%2Fimageserve%2F1164175639%2F960x0.jpg%3Ffit%3Dscale");	
					
				imageResults.add("https://realfood.tesco.com/media/images/Burger-31LGH-a296a356-020c-4969-86e8-d8c26139f83f-0-1400x919.jpg");
				imageResults.add("http://www.recipe4living.com/assets/itemimages/400/400/3/default_0dacefd503f9d9812f1221e5b670e95b_dreamstimesmall_50289207.jpg");
				imageResults.add("https://amp.thisisinsider.com/images/5571cbb9ecad04ea3f1d2bad-480-248.jpg");
				imageResults.add("https://cdn.pixabay.com/photo/2017/12/09/23/04/bread-3008950_960_720.jpg");
				imageResults.add("https://as1.ftcdn.net/jpg/00/43/43/08/500_F_43430821_7k8NyDsH7mWQscufbxbrw8wKezDhAKv7.jpg");
				imageResults.add("https://media.istockphoto.com/photos/tasty-burgers-on-wooden-table-picture-id860251286");
			} else {
				ImagesRequest ir = new ImagesRequest(query);
				imageResults = ir.imageResultURLs;
			}
			
			
			//thisUser.addRestaurant(restaurantResults.get(0), "favorite");
			//thisUser.addRecipe(recipeResults.get(0), "favorite");
			

			//setting session variable
			Gson gson = new Gson();
			
			
			session.setAttribute("resList", restaurantResults);
			session.setAttribute("recList", recipeResults);
			session.setAttribute("imgList", imageResults);
			session.setAttribute("userObj", thisUser);
		     
			//use JSON for javascript readability
		    String restJson = gson.toJson(restaurantResults);
		    String recipeJson = gson.toJson(recipeResults);
		    String imageJSON = gson.toJson(imageResults);
		    String userJSON =  gson.toJson(thisUser);
			
			session.setAttribute("restaurantResults", restJson);
			session.setAttribute("recipeResults", recipeJson);
			session.setAttribute("query", query);
			session.setAttribute("imageURLs", imageJSON);
			session.setAttribute("user", userJSON);
			session.setAttribute("options", numOptions);
		}
		
		RequestDispatcher dispatch = request.getRequestDispatcher("/Results.jsp?query=" + query);
		if (!(dispatch == null)) {
			dispatch.forward(request,  response);
		}
	}
}
