package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.RosterDetails;
import model.Player;
import model.Team;

/**
 * Servlet implementation class CreateNewRosterServlet
 */
@WebServlet("/createNewRosterServlet")
public class CreateNewRosterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CreateNewRosterServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PlayerHelper ph = new PlayerHelper();
		String teamName = request.getParameter("team_name");
		
		String[] selectedPlayers =
				request.getParameterValues("allPlayersToAdd");
		List<Player> selectedPlayersInRoster = new ArrayList<Player>();
		//make sure something was selected – otherwise we get a null pointer exception
		if (selectedPlayers != null && selectedPlayers.length > 0)
		{
			for(int i = 0; i< selectedPlayers.length; i++) {
				System.out.println(selectedPlayers[i]);
				Player p = ph.searchForPlayerById(Integer.parseInt(selectedPlayers[i]));
				selectedPlayersInRoster.add(p);
			}
		}
		
		TeamHelper th = new TeamHelper();
		Team team = th.findTeam(teamName);
		System.out.println("in createnewrostersevlet, teamName = " + teamName + ", which lead team.getTeamName() to be " + team.getTeamName());
		RosterDetails rd = new RosterDetails(team);
		rd.setListOfPlayers(selectedPlayersInRoster);
		RosterDetailsHelper rdh = new RosterDetailsHelper();
		rdh.insertNewRosterDetails(rd);
		
		getServletContext().getRequestDispatcher("/viewAllRostersServlet").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
