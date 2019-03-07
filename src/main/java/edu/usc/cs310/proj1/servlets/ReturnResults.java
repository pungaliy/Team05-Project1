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
			
			ImagesRequest ir = new ImagesRequest(query);
			imageResults = ir.imageResultURLs;
			
			
			
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
