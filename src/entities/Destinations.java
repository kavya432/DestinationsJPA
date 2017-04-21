package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="destinations")


public class Destinations {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="travel_id")
	private int id;
	@Column(name="traveller_country")
	private String travellerCountry;
	@Column(name="traveller_city")
	private String travellerCity;
	@Column(name="traveller_interest")
	private String travellerInterest;
	@Column(name="traveller_name")
	private String travellerName;
	@Column(name="traveller_gender")
	private String travellerGender;
	
    public Destinations(){
		
	}
	
	public Destinations(String c, String city, String i, String n, String g){
		this.travellerCountry = c;
		this.travellerCity  = city;
		this.travellerInterest = i;
		this.travellerName = n;
		this.travellerGender = g;
		
	}
	
	public Destinations(int id){
		this.id=id;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTravellerCountry() {
		return travellerCountry;
	}

	public void setTravellerCountry(String travellerCountry) {
		this.travellerCountry = travellerCountry;
	}

	public String getTravellerCity() {
		return travellerCity;
	}

	public void setTravellerCity(String travellerCity) {
		this.travellerCity = travellerCity;
	}

	public String getTravellerInterest() {
		return travellerInterest;
	}

	public void setTravellerInterest(String travellerInterest) {
		this.travellerInterest = travellerInterest;
	}

	public String getTravellerName() {
		return travellerName;
	}

	public void setTravellerName(String travellerName) {
		this.travellerName = travellerName;
	}

	public String getTravellerGender() {
		return travellerGender;
	}

	public void setTravellerGender(String travellerGender) {
		this.travellerGender = travellerGender;
	}
}



