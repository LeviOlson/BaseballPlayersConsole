package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Player;

@WebServlet(name = "viewAllServlet", urlPatterns = { "/viewAllServlet" })
public class ViewAllIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ViewAllIServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());	
		
		PlayerHelper dao = new PlayerHelper();
		request.setAttribute("all", dao.showAllPlayers());
		String path = "/player-list.jsp";
		
		//if the table is empty, the next page should be index.html instead so the user can populate the table
		if(dao.showAllPlayers().isEmpty()){
		path = "/index.html";
		System.out.println("The players table is empty");
		}
		
		//redirect to the next page
		getServletContext().getRequestDispatcher(path).forward(request, response); 
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
