/**  
 * @author Levi Olson - lolson17  
 * CIS175 - Spring 2021  
 * Mar 3, 2021  
 */

package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="roster_details")
public class RosterDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="roster_id")
	private int id;
	@ManyToOne (cascade=CascadeType.PERSIST)
	@JoinColumn(name="team_id")
	private Team team;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	@JoinTable
	(
			name="players_on_roster",
			joinColumns={ @JoinColumn(name="roster_id",
			referencedColumnName="roster_id") },
			inverseJoinColumns={ @JoinColumn(name="player_id",
			referencedColumnName="id", unique=true) }
			)
	private List<Player> listOfPlayers;


	public RosterDetails(int id, Team team, List<Player> listOfPlayers) {
		super();
		this.id = id;
		this.team = team;
		this.listOfPlayers = listOfPlayers;
	}

	public RosterDetails(Team team, List<Player> listOfPlayers) {
		super();
		this.team = team;
		this.listOfPlayers = listOfPlayers;
	}

	public RosterDetails(Team team) {
		super();
		this.team = team;
	}

	private RosterDetails() {
		super();
	}

	public List<Player> getListOfPlayers() {
		return listOfPlayers;
	}

	public void setListOfPlayers(List<Player> setListOfPlayers) {
		this.listOfPlayers = listOfPlayers;
	}

	@Override
	public String toString() {
		return "RosterDetails [id=" + id + ", team=" + team
				+ ", listOfPlayers=" + listOfPlayers + "]";
	}

	public int getId() {
		return id;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	

}
