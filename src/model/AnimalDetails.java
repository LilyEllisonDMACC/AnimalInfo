/**
 * @author tehli - lbellison
 * CIS175 - Fall 2023
 * Sep 29, 2023
 */
package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author LILY ELLISON - LBELLISON
 * CIS175 - FALL 2023
 * Sep 29, 2023
 */
@Entity
public class AnimalDetails {
	@Id
	@GeneratedValue
	private int id;
	private String ownershipName;
	@ManyToOne (cascade=CascadeType.PERSIST)
	private Owner owner;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<AnimalList> listOfAnimals;
	
	public AnimalDetails() {
		super();
	}
	
	public AnimalDetails(int id, String ownershipName, Owner owner, List<AnimalList> listOfAnimals) {
		super();
		this.id = id;
		this.ownershipName = ownershipName;
		this.owner = owner;
		this.listOfAnimals = listOfAnimals;
	}
	
	public AnimalDetails(String ownershipName, Owner owner, List<AnimalList> listOfAnimals) {
		super();
		this.ownershipName = ownershipName;
		this.owner = owner;
		this.listOfAnimals = listOfAnimals;
	}
	
	public AnimalDetails(String ownershipName, Owner owner) {
		super();
		this.ownershipName = ownershipName;
		this.owner = owner;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the ownershipName
	 */
	public String getOwnershipName() {
		return ownershipName;
	}

	/**
	 * @param ownershipName the ownershipName to set
	 */
	public void setOwnershipName(String ownershipName) {
		this.ownershipName = ownershipName;
	}

	/**
	 * @return the owner
	 */
	public Owner getOwner() {
		return owner;
	}

	/**
	 * @param owner the owner to set
	 */
	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	/**
	 * @return the listOfAnimals
	 */
	public List<AnimalList> getListOfAnimals() {
		return listOfAnimals;
	}

	/**
	 * @param listOfAnimals the listOfAnimals to set
	 */
	public void setListOfAnimals(List<AnimalList> listOfAnimals) {
		this.listOfAnimals = listOfAnimals;
	}
	
	@Override
	public String toString() {
		return "AnimalDetails [id = " + id + ", ownershipName = " + ownershipName + ", owner = " + owner + ", listOfAnimals = " + listOfAnimals + "]";
	}

}
