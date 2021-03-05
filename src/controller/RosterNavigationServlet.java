package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.RosterDetails;

/**
 * Servlet implementation class RosterNavigationServlet
 */
@WebServlet("/rosterNavigationServlet")
public class RosterNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RosterNavigationServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RosterDetailsHelper dao = new RosterDetailsHelper();

		String act = request.getParameter("doThisToRoster");
		if (act == null) {
			// no button has been selected
			getServletContext().getRequestDispatcher("/viewAllRostersServlet").forward(request, response);
		} else if (act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				RosterDetails rosterToDelete = dao.searchForRosterDetailsById(tempId);
				dao.deleteList(rosterToDelete);
			} catch (NumberFormatException e) {
				System.out.println("Forgot to click a button");
			} finally {
				getServletContext().getRequestDispatcher("/viewAllRostersServlet").forward(request, response);
			}
		} else if (act.equals("add")) {
			getServletContext().getRequestDispatcher("/new-roster.html").forward(request, response);
		}
	}
}