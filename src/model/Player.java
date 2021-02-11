/**  
* @author Levi Olson - lolson17  
* CIS175 - Spring 2021  
* Feb 10, 2021  
*/

package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="players")
public class Player {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Column(name="FName")
	private String fname;
	@Column(name="lname")
	private String lname;
	@Column(name="Number")
	private int number;
	public Player() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFName() {
		return fname;
	}
	public void setFName(String fname) {
		this.fname = fname;
	}
	public String getLName() {
		return lname;
	}
	public void setLName(String lname) {
		this.lname = lname;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public Player(String fname, String lname, int number) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.number = number;
	}
	
	public String toString()
	{
		return "Number " + number + ", " + fname + " " + lname;
	}
	
}
