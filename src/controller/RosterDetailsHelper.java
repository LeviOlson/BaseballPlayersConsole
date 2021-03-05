/**  
 * @author Levi Olson - lolson17  
 * CIS175 - Spring 2021  
 * Mar 3, 2021  
 */

package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.RosterDetails;
import model.Team;

public class RosterDetailsHelper {

	static EntityManagerFactory emfactory =
			Persistence.createEntityManagerFactory("BaseballPlayersWeb");

	public void insertNewRosterDetails(RosterDetails r) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(r);
		em.getTransaction().commit();
		em.close();
		}

	public List<RosterDetails> getRosters() {
		EntityManager em = emfactory.createEntityManager();
		List<RosterDetails> allDetails = em.createQuery("SELECT d FROM RosterDetails d").getResultList();
		return allDetails;
	}

	public void deleteList(RosterDetails toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<RosterDetails> typedQuery = em.createQuery("select detail from RosterDetails detail where detail.id = :selectedId", RosterDetails.class);
		// Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedId", toDelete.getId());
		// we only want one result
		typedQuery.setMaxResults(1);
		// get the result and save it into a new roster item
		RosterDetails result = typedQuery.getSingleResult();
		// remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	public RosterDetails searchForRosterDetailsById(Integer tempId) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		RosterDetails found = em.find(RosterDetails.class, tempId);
		em.close();
		return found;
	}
}
