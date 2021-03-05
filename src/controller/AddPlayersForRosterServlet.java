package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddPlayersForRosterServlet
 */
@WebServlet("/addPlayersForRosterServlet")
public class AddPlayersForRosterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public AddPlayersForRosterServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		PlayerHelper dao = new PlayerHelper();
		request.setAttribute("allPlayers", dao.showAllPlayers());
		
		if(dao.showAllPlayers().isEmpty()) {
			request.setAttribute("allPlayers", " ");
		}
		
		getServletContext().getRequestDispatcher("/new-roster.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
