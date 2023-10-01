/**
 * @author tehli - lbellison
 * CIS175 - Fall 2023
 * Sep 29, 2023
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author LILY ELLISON - LBELLISON
 * CIS175 - FALL 2023
 * Sep 29, 2023
 */

@Entity
@Table(name="owner")
public class Owner {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="NAME")
	private String owner;
	
	public Owner() {
		super();
	}

	public Owner(int id, String ownerName) {
		super();
		this.id = id;
		this.owner = ownerName;
	}
	
	public Owner(String ownerName) {
		this.owner = ownerName;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOwnerName() {
		return owner;
	}
	public void setOwnerName(String ownerName) {
		this.owner = ownerName;
	}
	
	@Override
	public String toString() {
		return "Owner [id = " + id + ", ownerName = " + owner + "]";
	}
}
