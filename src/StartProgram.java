
/**  
* @author Levi Olson - lolson17  
* CIS175 - Spring 2021  
* Feb 10, 2021  
*/
import java.util.List;
import java.util.Scanner;

import controller.PlayerHelper;
import model.Player;

public class StartProgram {

		static Scanner in = new Scanner(System.in);
		static PlayerHelper ph = new PlayerHelper();

		private static void addAPlayer() {
			// TODO Auto-generated method stub
			System.out.print("Enter a first name: ");
			String fname = in.nextLine();
			System.out.print("Enter a last name: ");
			String lname = in.nextLine();
			System.out.print("Enter the jersey number: ");
			int number = in.nextInt();
			Player toAdd = new Player(fname, lname, number);
			System.out.println("Preparing to add " + toAdd);
			ph.insertPlayer(toAdd);
		}

		private static void deleteAPlayer() {
			// TODO Auto-generated method stub
			System.out.print("Enter the first name to delete: ");
			String fname = in.nextLine();
			System.out.print("Enter the last name to delete: ");
			String lname = in.nextLine();
			System.out.println("Enter the jersey number to delete: ");
			int number = in.nextInt();
			Player toDelete = new Player(fname, lname, number);
			ph.deletePlayer(toDelete);
		}

		private static void editAPlayer() {
			// TODO Auto-generated method stub
			System.out.println("How would you like to search? ");
			System.out.println("1 : Search by first name");
			System.out.println("2 : Search by last name");
			System.out.println("3 : Search by jersey number");
			int searchBy = in.nextInt();
			in.nextLine();
			
			List<Player> foundPlayers;
			if (searchBy == 1) {
				System.out.print("Enter the first name: ");
				String fname = in.nextLine();
				foundPlayers = ph.searchForPlayerByFName(fname);
			} else if (searchBy == 2) {
				System.out.print("Enter the last name: ");
				String lname = in.nextLine();
				foundPlayers = ph.searchForPlayerByLName(lname);
				}
			else {
				System.out.print("Enter the jersey number: ");
				int number = in.nextInt();
				foundPlayers = ph.searchForPlayerByNumber(number);
			}


			if (!foundPlayers.isEmpty()) {
				System.out.println("Found Results.");
				for (Player l : foundPlayers) {
					System.out.println(l.getId() + " : " + l.toString());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();

				Player toEdit = ph.searchForPlayerById(idToEdit);
				System.out.println("Retrieved " + toEdit.toString());
				System.out.println("1 : Update First Name");
				System.out.println("2 : Update Last Name");
				System.out.println("3 : Update Jersey Numner");
				int update = in.nextInt();
				in.nextLine();

				System.out.println("Enter new value: ");
				String newVal = in.nextLine();
				
				if (update == 1)
				{
					toEdit.setFName(newVal);
				}
				else if (update == 2)
				{
					toEdit.setLName(newVal);
				}
				else
				{
					toEdit.setNumber(Integer.parseInt(newVal));
				}

				ph.updatePlayer(toEdit);

			} else {
				System.out.println("---- No results found");
			}

		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			runMenu();

		}

		public static void runMenu() {
			boolean goAgain = true;
			System.out.println("--- Welcome to the baseball players database ---");
			while (goAgain) {
				System.out.println("*  Select an option:");
				System.out.println("*  1 -- Add a player");
				System.out.println("*  2 -- Edit a player");
				System.out.println("*  3 -- Delete a player");
				System.out.println("*  4 -- View the list");
				System.out.println("*  5 -- Exit the program");
				System.out.print("*  Your selection: ");
				int selection = in.nextInt();
				in.nextLine();

				if (selection == 1) {
					addAPlayer();
				} else if (selection == 2) {
					editAPlayer();
				} else if (selection == 3) {
					deleteAPlayer();
				} else if (selection == 4) {
					viewTheList();
				} else {
					ph.cleanUp();
					System.out.println("   Goodbye!   ");
					goAgain = false;
				}

			}

		}

		private static void viewTheList() {
			List<Player> allItems = ph.showAllPlayers();
			for(Player player : allItems){
			System.out.println(player.toString());
		}
		}
	}