/**  
* @author Levi Olson - lolson17  
* CIS175 - Spring 2021  
* Mar 3, 2021  
*/

package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//package and import statements
@Entity
@Table(name="team")
public class Team {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="team_id")
	private int id;
	@Column(name="team_name")
	private String teamName;
	
	public Team() {
		super();
	}
	public Team(int id, String teamName) {
		super();
		this.id = id;
		this.teamName = teamName;
	}
	public Team(String teamName) {
		super();
		this.teamName = teamName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String shopperName) {
		this.teamName = teamName;
	}
	@Override
	public String toString() {
		return "Team [id=" + id + ", teamName=" +
				teamName + "]";
	}

}