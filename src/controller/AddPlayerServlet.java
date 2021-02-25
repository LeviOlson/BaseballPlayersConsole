package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Player;


@WebServlet("/addPlayerServlet")
public class AddPlayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddPlayerServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get input from web page
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String numStr = request.getParameter("num");
				
		//ensure that the number is a valid int
		try
		{
			int num = Integer.parseInt(numStr);
			
			//add item to database
			Player p = new Player(fname, lname, num);
			PlayerHelper dao = new PlayerHelper();
			dao.insertPlayer(p);
		}
		//do not add data is number is not a valid int
		catch (NumberFormatException ex)
		{
			//inform the user of their invalid data
			System.out.println("Number must be a valid integer");
		}
		
		//refresh by redirecting to index.html (which is where you should already be)
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
