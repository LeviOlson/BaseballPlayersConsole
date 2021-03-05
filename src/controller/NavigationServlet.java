package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Player;


@WebServlet(name = "navigationServlet", urlPatterns = { "/navigationServlet" })
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NavigationServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("doThisToPlayer");
		// after all changes, we should redirect to the viewAllServlet
		// The only time we don't is if they select to add a new player or edit
		String path = "/viewAllPlayersServlet";
		
		PlayerHelper dao = new PlayerHelper();		
		
		if (act.equals("delete")) {
			
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Player toDelete = dao.searchForPlayerById(tempId);
				dao.deletePlayer(toDelete);
				} catch (NumberFormatException e) {
				System.out.println("Forgot to select a player to delete, id = " + request.getParameter("id"));
				} 

		} else if (act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Player toEdit = dao.searchForPlayerById(tempId);
				request.setAttribute("toEdit", toEdit);
				path = "/edit-player.jsp";
				} catch (NumberFormatException e) {
				System.out.println("Forgot to select a player to edit, id = " + request.getParameter("id"));
				}
		} else if (act.equals("add")) {
		path = "/index.html";
		}
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}
}
