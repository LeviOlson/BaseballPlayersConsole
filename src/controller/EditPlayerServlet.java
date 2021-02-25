package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Player;


@WebServlet(name = "editPlayerServlet", urlPatterns = { "/editPlayerServlet" })
public class EditPlayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditPlayerServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//find user input and use it to find the item we want to update
		PlayerHelper dao = new PlayerHelper();
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String numStr = request.getParameter("num");
				
		//ensure that the number is a valid int
		try
		{
			int num = Integer.parseInt(numStr);
			
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			Player toUpdate = dao.searchForPlayerById(tempId);
			
			//update player
			toUpdate.setFName(fname);
			toUpdate.setLName(lname);
			toUpdate.setNumber(num);
			dao.updatePlayer(toUpdate);
		}
		//do not edit data is number is not a valid int
		catch (NumberFormatException ex)
		{
			//inform the user of their invalid data
			System.out.println("Number must be a valid integer");
		}
		
		//redirect to player list
		getServletContext().getRequestDispatcher("/viewAllServlet").forward(request, response);
	}

}
