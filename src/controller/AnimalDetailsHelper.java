/**
 * @author tehli - lbellison
 * CIS175 - Fall 2023
 * Sep 29, 2023
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.AnimalDetails;

/**
 * @author LILY ELLISON - LBELLISON
 * CIS175 - FALL 2023
 * Sep 29, 2023
 */
public class AnimalDetailsHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("AnimalInfo");
	
	public void insertNewAnimalDetails(AnimalDetails o) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(o);;
		em.getTransaction().commit();
		em.close();
	}
	
	public List<AnimalDetails> getAnimals() {
		EntityManager em = emfactory.createEntityManager();
		List<AnimalDetails> allAnimals = em.createQuery("SELECT a FROM AnimalDetails a").getResultList();
		return allAnimals;
	}
	
	public void deleteAnimal(AnimalDetails toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<AnimalDetails> typedQuery = em.createQuery("select detail from AnimalDetails detail where detail.id = :selectedId", AnimalDetails.class);
		typedQuery.setParameter("selectedId", toDelete.getId());
		typedQuery.setMaxResults(1);
		AnimalDetails result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public AnimalDetails searchForAnimalDetailsById(Integer tempId) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		AnimalDetails found = em.find(AnimalDetails.class, tempId);
		em.close();
		return found;
	}
	
	public void updateAccount(AnimalDetails toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

}
