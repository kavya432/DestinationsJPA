package application;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import entities.Destinations;

public class DeleteDestination {

	public void deleteDestination(){
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("DestinationsOnlineJPA");
		EntityManager em = emfactory.createEntityManager();
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a Destination travel id to delete: ");
		int selectedId = in.nextInt();
		em.getTransaction().begin();
		TypedQuery<Destinations> selectedCountryQuery = em.createQuery("select li from Destinations li where li.id = :selectedid", Destinations.class);
		selectedCountryQuery.setParameter("selectedid", selectedId);
		selectedCountryQuery.setMaxResults(1);
		Destinations toDelete = selectedCountryQuery.getSingleResult();
		em.remove(toDelete);
		em.getTransaction().commit();
		em.close();
	}

}
