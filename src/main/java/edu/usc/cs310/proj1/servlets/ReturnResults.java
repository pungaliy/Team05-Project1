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
				
		String query = request.getParameter("query");
		String options = request.getParameter("options");	
		int numOptions = Integer.parseInt(options);
		
		User thisUser = new User();
        //User u = (User) request.getSession().getAttribute("User");
		session.setAttribute("enter", "out");
		
		//check if already search
		if(session.getAttribute("query") == null || !session.getAttribute("query").equals(query) ||
				(session.getAttribute("query").equals(query) && (int)session.getAttribute("options") != numOptions)) {
			 
			//((session.getAttribute("options") != null) && (session.getAttribute("options") != options))
			
			session.setAttribute("enter", "in");
		
			ArrayList<Restaurant> restaurantResults = new ArrayList<Restaurant>();
			ArrayList<Recipe> recipeResults = new ArrayList<Recipe>();
			ArrayList<String> imageResults = new ArrayList<String>();
			
//			for(Recipe r : recipeResults) {
//				r.uniqueID = ""
//			}
			
			thisUser.query(query, numOptions, restaurantResults, recipeResults, imageResults);
			
			YelpRequest y = new YelpRequest(query, numOptions);
			restaurantResults = y.restaurantResults;
			
			RecipeRequest r = new RecipeRequest(query, numOptions);
			recipeResults = r.recipeResults;
			

//			ImagesRequest ir = new ImagesRequest(query);
//			imageResults = ir.imageResultURLs;


			if(query.contentEquals("hamburger")) {
				imageResults.add("https://assets.epicurious.com/photos/57c5c6d9cf9e9ad43de2d96e/6:4/w_620%2Ch_413/the-ultimate-hamburger.jpg");
				imageResults.add("https://www.thespruceeats.com/thmb/IVEwZUNTa5XGDFhGtbF8iFaxn3I=/960x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/Hamburger-Hot-Dog-58add5f03df78c345bdef6ff.jpg");
				imageResults.add("https://recipes-secure-graphics.grocerywebsite.com/0_GraphicsRecipes/4589_4k.jpg");
				imageResults.add("https://www.justataste.com/wp-content/uploads/2013/05/Homemade-Cheeseburger-Buns.jpg");
				imageResults.add("https://realfood.tesco.com/media/images/Burger-31LGH-a296a356-020c-4969-86e8-d8c26139f83f-0-1400x919.jpg");
				imageResults.add("http://www.recipe4living.com/assets/itemimages/400/400/3/default_0dacefd503f9d9812f1221e5b670e95b_dreamstimesmall_50289207.jpg");
				imageResults.add("https://amp.thisisinsider.com/images/5571cbb9ecad04ea3f1d2bad-480-248.jpg");
				imageResults.add("https://cdn.pixabay.com/photo/2017/12/09/23/04/bread-3008950_960_720.jpg");
				imageResults.add("https://as1.ftcdn.net/jpg/00/43/43/08/500_F_43430821_7k8NyDsH7mWQscufbxbrw8wKezDhAKv7.jpg");
				imageResults.add("https://media.istockphoto.com/photos/tasty-burgers-on-wooden-table-picture-id860251286");
			}			
			
			
			//thisUser.addRestaurant(restaurantResults.get(0), "favorite");
			//thisUser.addRecipe(recipeResults.get(0), "favorite");
			

			Gson gson = new Gson();
			
			
			session.setAttribute("resList", restaurantResults);
			session.setAttribute("recList", recipeResults);
			session.setAttribute("imgList", imageResults);
			session.setAttribute("userObj", thisUser);
		      
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
		dispatch.forward(request,  response);
	}
}
