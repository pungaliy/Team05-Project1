package edu.usc.cs310.proj1.servlets;

import java.io.IOException;
import java.util.ArrayList;


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
@WebServlet("/AddToServlet")
public class AddToServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		HttpSession session = request.getSession();
		String id = request.getParameter("id");
		String item = request.getParameter("item");
		String list = request.getParameter("list");
		
		session.setAttribute("id", id);
		if(item.equals("Restaurant")) {
			session.setAttribute("item", item);
		}
		session.setAttribute("list", list);
		
		
		
		User thisUser = (User) session.getAttribute("userObj");
		
		
		if(item.equals("Restaurant")) {
			
			ArrayList<Restaurant> resList = (ArrayList<Restaurant>) session.getAttribute("resList");
			session.setAttribute("list", resList);
			Restaurant rs = null;
			for(int i = 0; i < resList.size(); i++) {
				if(resList.get(i).uniqueID.equals(id)) {
					session.setAttribute("in", "IHSDIDSHI");
					rs = resList.get(i);
				}
			}
			session.setAttribute("check", rs);
			thisUser.addRestaurant(rs, list);
			
		}
		else {
			ArrayList<Recipe> rec = (ArrayList<Recipe>) session.getAttribute("recList");
			thisUser.addRecipe(rec.get(Integer.parseInt(id)), list);
		}
		
		
		session.setAttribute("userObj", thisUser);
		
		Gson gson = new Gson();
		String userJSON = gson.toJson(thisUser);
		
		
	    session.setAttribute("user", userJSON);
		
		
	}
}