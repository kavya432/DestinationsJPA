package application;


import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


import entities.Destinations;

public class ReadDestinations {

	public void ViewDestinations() {
		// TODO Auto-generated method stub
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("DestinationsOnlineJPA");
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a Destination Country: ");
		String selectedCountry = in.nextLine();
		//javax.persistence.TypedQuery<Listitem> selectedStoreQuery =  em.createQuery("select li from Listitem li where li.store = '" + selectedStore + "'", Listitem.class);
		 TypedQuery<Destinations> selectedCountryQuery = em.createQuery("select li from Destinations li where li.travellerCountry = :selectedcountry", Destinations.class);
		 selectedCountryQuery.setParameter("selectedcountry", selectedCountry);
		 List<Destinations> results = selectedCountryQuery.getResultList();
		
		 for(Destinations a : results){
			System.out.println("Traveller Name: "+ a.getTravellerName());
			System.out.println("Traveller City: " + a.getTravellerCity());
			System.out.println("Traveller Interest: " + a.getTravellerInterest());
		}
		em.close();
		emfactory.close();
		
	}

	}


