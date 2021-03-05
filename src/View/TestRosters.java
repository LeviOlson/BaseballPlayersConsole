/**  
* @author Levi Olson - lolson17  
* CIS175 - Spring 2021  
* Mar 4, 2021  
*/

package View;

import java.util.List;

import controller.RosterDetailsHelper;
import model.Player;
import model.RosterDetails;

public class TestRosters {

	public TestRosters() {
	}

	public static void main(String[] args) {
		RosterDetailsHelper rdh = new RosterDetailsHelper();
		List<RosterDetails> rdl = rdh.getRosters();
		
		for (RosterDetails rd : rdl) 
		{ 
			System.out.println(rd.getTeam().getTeamName() + " has\n");
		    for (Player p : rd.getListOfPlayers())
		    {
		    	System.out.println(p.toString());
		    }
		}
		System.out.println("that is the complete list");
	}

}
