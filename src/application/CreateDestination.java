package application;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import entities.Destinations;



public class CreateDestination {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("DestinationsOnlineJPA");


	public void cleanUp(){
		emfactory.close();
	}

	public void CreateDestination() {
		Scanner in = new Scanner(System.in);
		System.out.println("Destination Country: ");
		String country= in.nextLine();
		System.out.println("Destination City: ");
		String city= in.nextLine();
		System.out.println("Interest: ");
		String interest = in.nextLine();
		System.out.println("Traveller Name: ");
		String name= in.nextLine();
		System.out.println("Traveller gender: ");
		String gender= in.nextLine();
		Destinations toAdd = new Destinations(country,city,interest,name,gender);

		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();

		em.persist(toAdd);
		em.getTransaction().commit();
		em.close();
	}

	public Destinations UpdateDestinationInterestbyId(int id){
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();

		Destinations toUpdate = em.find(Destinations.class, id);
		em.close();
		return toUpdate;
	}

	public void updateInterest(Destinations editInteret){
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(editInteret);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Destinations> showAllDestinations(){
		EntityManager em = emfactory.createEntityManager();
	   	TypedQuery<Destinations> selectedQuery = em.createQuery("select li from Destinations li", Destinations.class);
	   	List<Destinations> allDestinations = selectedQuery.getResultList();
	   	em.close();
	   	return allDestinations;
	   	
	   	
	   	
	}
	
}
	
	



