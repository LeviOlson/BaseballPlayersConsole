/**  
* @author Levi Olson - lolson17  
* CIS175 - Spring 2021  
* Feb 10, 2021  
*/

package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Player;

public class PlayerHelper {
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("BaseballPlayersConsole");

	public PlayerHelper() {
		
	}
	
	public void insertPlayer(Player player)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(player);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Player> showAllPlayers(){
		EntityManager em = emfactory.createEntityManager();
			List<Player> all = em.createQuery("SELECT i FROM Player i").getResultList();
			return all;
			}
	
	public void deletePlayer(Player toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Player> typedQuery = em.createQuery("select player from Player player where player.fname = :selectedfname and player.lname = :selectedlname and player.number =:selectedNumber", Player.class);

		//Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedfname", toDelete.getFName());
		typedQuery.setParameter("selectedlname", toDelete.getLName());
		typedQuery.setParameter("selectedNumber", toDelete.getNumber());

		//we only want one result
		typedQuery.setMaxResults(1);

		//get the result and save it into a new list item
		Player result = typedQuery.getSingleResult();

		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public Player searchForPlayerById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Player found = em.find(Player.class, idToEdit);
		em.close();
		return found;
	}
	
	public void updatePlayer(Player toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Player> searchForPlayerByFName(String fname) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Player> typedQuery = em.createQuery("select player from Player player where player.fname = :selectedfname", Player.class);
		typedQuery.setParameter("selectedfname", fname);

		List<Player> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
}
	
	public List<Player> searchForPlayerByLName(String lname) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Player> typedQuery = em.createQuery("select player from Player player where player.lname = :selectedlname", Player.class);
		typedQuery.setParameter("selectedlname", lname);

		List<Player> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
}
	
	public List<Player> searchForPlayerByNumber(int number) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Player> typedQuery = em.createQuery("select player from Player player where player.number = :selectedNumber", Player.class);
		typedQuery.setParameter("selectedNumber", number);

		List<Player> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
}
	
	public void cleanUp(){
		emfactory.close();
	}

}
