/**  
 * @author Levi Olson - lolson17  
 * CIS175 - Spring 2021  
 * Mar 3, 2021  
 */

package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Team;

public class TeamHelper {
	static EntityManagerFactory emfactory =
			Persistence.createEntityManagerFactory("BaseballPlayersWeb");


	public void insertShopper(Team t) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
		em.close();
	}


	public List<Team> showAllTeams() {
		EntityManager em = emfactory.createEntityManager();
		List<Team> allTeams = em.createQuery("SELECT t FROM Team t").getResultList();
		return allTeams;
	}

	public Team findTeam(String nameToLookUp) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Team> typedQuery = em.createQuery("select t from Team t where t.teamName = :selectedName", Team.class);
		typedQuery.setParameter("selectedName", nameToLookUp);
		Team foundTeam;
		try {
			foundTeam = typedQuery.getSingleResult();
		} catch (NoResultException ex) {
			foundTeam = new Team(nameToLookUp);
		}
		em.close();
		return foundTeam;
	}
}