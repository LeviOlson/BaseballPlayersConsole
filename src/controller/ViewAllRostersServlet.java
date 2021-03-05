package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.RosterDetails;

/**
 * Servlet implementation class ViewAllRostersServlet
 */
@WebServlet("/viewAllRostersServlet")
public class ViewAllRostersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public ViewAllRostersServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());

		RosterDetailsHelper rdh = new RosterDetailsHelper();
		List<RosterDetails> rdl = rdh.getRosters();
		request.setAttribute("allRosters", rdl);
		if(rdl.isEmpty()){
			request.setAttribute("allRosters", " ");
		}
		getServletContext().getRequestDispatcher("/roster-by-user.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
