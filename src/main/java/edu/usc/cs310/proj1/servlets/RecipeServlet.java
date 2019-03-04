package edu.usc.cs310.proj1.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.io.PrintWriter;

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
import edu.usc.cs310.proj1.objects.YelpRequest;

/**
 * Servlet implementation class searchUser
 */
@WebServlet("/recipes")
public class RecipeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecipeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
				
		String ID = request.getParameter("query");
		String options = request.getParameter("options");	
		int numOptions = Integer.parseInt(options);
		
		ArrayList<Restaurant> restaurantResults = new ArrayList<Restaurant>();
		ArrayList<Recipe> recipeResults = new ArrayList<Recipe>();
		ArrayList<String> imageResults = new ArrayList<String>();
		
		session.setAttribute("restaurantResults", restaurantResults);
		session.setAttribute("recipeResults", recipeResults);
		session.setAttribute("imageURLs", imageResults);
		RequestDispatcher dispatch = request.getRequestDispatcher("/Results.html");
		dispatch.forward(request,  response);
	}
}