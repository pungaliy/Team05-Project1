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

				
		//get current user session
		User thisUser = (User) session.getAttribute("userObj");
		ArrayList<Restaurant> resList = (ArrayList<Restaurant>) session.getAttribute("resList");
		ArrayList<Recipe> recList = (ArrayList<Recipe>) session.getAttribute("recList");
		
		
		//check which items to add
		if(item.equals("Restaurant")) {
			
			session.setAttribute("list", resList);
			Restaurant rs = null;
			//get restaurant item from list
			for(int i = 0; i < resList.size(); i++) {
				if(resList.get(i).uniqueID.equals(id)) {
					rs = resList.get(i);
				}
			}
			//add restaurant
			thisUser.addRestaurant(rs, list);
			//check which lists it moves to
			if(list.equals("favorite")) {
				resList.remove(rs);
				resList.add(0, rs);
			}
			else if (list.equals("not")) {
				resList.remove(rs);
				rs.isDoNotExplore = true;
			}
		}
		else {
			//get recipe item from list
			Recipe rc = recList.get(Integer.parseInt(id));
			thisUser.addRecipe(rc, list);
			//check which lists it moves to
			if(list.equals("favorite")) {
				recList.remove(rc);
				recList.add(0, rc);
			}
			else if (list.equals("not")){
				recList.remove(rc);
				rc.isDoNotExplore = true;
			}
		}
		
		//resetting session
		session.setAttribute("userObj", thisUser);
		
		Gson gson = new Gson();
		String userJSON = gson.toJson(thisUser);
		String resJSON = gson.toJson(resList);
		String recJSON = gson.toJson(recList);
		

	    session.setAttribute("user", userJSON);
	    session.setAttribute("resList", resList);
	    session.setAttribute("recList", recList);
	    session.setAttribute("restaurantResults", resJSON);
	    session.setAttribute("recipeResults", recJSON);
		
	}
}