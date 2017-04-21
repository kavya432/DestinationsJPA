package application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Destinations;

public class UpdateDestinations {

	public Destinations UpdateDestinationInterestbyId(int id){
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("DestinationsOnlineJPA");
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();

		Destinations toUpdate = em.find(Destinations.class, id);
		em.close();
		return toUpdate;
	}

	public void updateInterest(Destinations editInteret){
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("DestinationsOnlineJPA");
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(editInteret);
		em.getTransaction().commit();
		em.close();
	}
}
