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
//		RequestDispatcher dispatch2 = request.getRequestDispatcher("/Results.html");
//		dispatch2.forward(request, response);
		HttpSession session = request.getSession();
				
		String query = request.getParameter("query");
		String options = request.getParameter("options");	
		int numOptions = Integer.parseInt(options);
		
		User thisUser = new User();
        session.setAttribute("User", thisUser);
        //User u = (User) request.getSession().getAttribute("User");
		
		
		ArrayList<Restaurant> restaurantResults = new ArrayList<Restaurant>();
		ArrayList<Recipe> recipeResults = new ArrayList<Recipe>();
		ArrayList<String> imageResults = new ArrayList<String>();
		
		YelpRequest y = new YelpRequest(query, numOptions);
		restaurantResults = y.restaurantResults;
		
		RecipeRequest r = new RecipeRequest(query, numOptions);
		recipeResults = r.recipeResults;
		
		
		
		session.setAttribute("restaurantResults", restaurantResults);
		session.setAttribute("recipeResults", recipeResults);
		session.setAttribute("imageURLs", imageResults);
		RequestDispatcher dispatch = request.getRequestDispatcher("/Results.html");
		dispatch.forward(request,  response);
	}
}