package edu.usc.cs310.proj1.servlets;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import edu.usc.cs310.proj1.objects.Recipe;
import edu.usc.cs310.proj1.objects.Restaurant;
import edu.usc.cs310.proj1.objects.User;


/**
 * Servlet implementation for adding items to list
 */
@WebServlet("/RemoveListServlet")
public class RemoveListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		HttpSession session = request.getSession();
				
		String list1 = request.getParameter("list");
		String type = request.getParameter("itemType");
		session.setAttribute("type", type);
		session.setAttribute("list", list1);
		
		int index = Integer.parseInt(request.getParameter("index"));
		session.setAttribute("index", index);
		
        User thisUser = (User) session.getAttribute("userObj");
        
        if(type.equals("restaurant")) {
        	session.setAttribute("check", "a");
        	thisUser.removeRestaurant(list1, index);
        }
        else if(type.equals("recipe")) {
        	session.setAttribute("check", "b");
        	thisUser.removeRecipe(list1, index);
        }

		session.setAttribute("userObj", thisUser);
		
		Gson gson = new Gson();
		String userJSON = gson.toJson(thisUser);
		
	    session.setAttribute("user", userJSON);
		
	}
}