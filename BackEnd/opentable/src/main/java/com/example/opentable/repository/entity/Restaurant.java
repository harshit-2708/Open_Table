package com.example.opentable.repository.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "restaurants")
public class Restaurant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int restaurant_Id;
	
	@Column
	private String restaurant_Name;
	
	@Column
	private String address;
	
	@Column
	private String gstIn;
	
	@Column 
	private String contact;
	
	@Column
	private boolean nonVeg;
	
	@Column
	private String description;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ownerId")
	private User owner;

	@OneToMany(mappedBy = "restaurant")
	private List<Photo> photos = new ArrayList<>();
	
	@OneToMany(mappedBy = "restaurant")
	private List<Recipe> recipes = new ArrayList<>();
	
	@OneToMany(mappedBy = "restaurant")
	private List<Review> reviews = new ArrayList<>();
	
	@OneToMany(mappedBy = "restaurant")
	private List<Bench> benches = new ArrayList<>();
	
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Cuisine> cuisines = new ArrayList<>();

	public Restaurant() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Restaurant(int restaurant_Id, String restaurant_Name, String address, String gstIn, String contact,
			boolean nonVeg, String description, User owner, List<Photo> photos, List<Recipe> recipes,
			List<Review> reviews, List<Bench> benches, List<Cuisine> cuisines) {
		super();
		this.restaurant_Id = restaurant_Id;
		this.restaurant_Name = restaurant_Name;
		this.address = address;
		this.gstIn = gstIn;
		this.contact = contact;
		this.nonVeg = nonVeg;
		this.description = description;
		this.owner = owner;
		this.photos = photos;
		this.recipes = recipes;
		this.reviews = reviews;
		this.benches = benches;
		this.cuisines = cuisines;
	}



	public int getRestaurant_Id() {
		return restaurant_Id;
	}

	public void setRestaurant_Id(int restaurant_Id) {
		this.restaurant_Id = restaurant_Id;
	}

	public String getRestaurant_Name() {
		return restaurant_Name;
	}

	public void setRestaurant_Name(String restaurant_Name) {
		this.restaurant_Name = restaurant_Name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGstIn() {
		return gstIn;
	}

	public void setGstIn(String gstIn) {
		this.gstIn = gstIn;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public boolean isNonVeg() {
		return nonVeg;
	}

	public void setNonVeg(boolean nonVeg) {
		this.nonVeg = nonVeg;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	
	

	public List<Photo> getPhotos() {
		return photos;
	}



	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}



	public List<Recipe> getRecipes() {
		return recipes;
	}



	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}



	public List<Review> getReviews() {
		return reviews;
	}



	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}



	public List<Bench> getBenches() {
		return benches;
	}



	public void setBenches(List<Bench> benches) {
		this.benches = benches;
	}



	public List<Cuisine> getCuisines() {
		return cuisines;
	}



	public void setCuisines(List<Cuisine> cuisines) {
		this.cuisines = cuisines;
	}



	@Override
	public String toString() {
		return "Restaurant [restaurant_Id=" + restaurant_Id + ", restaurant_Name=" + restaurant_Name + ", address="
				+ address + ", gstIn=" + gstIn + ", contact=" + contact + ", nonVeg=" + nonVeg + ", description="
				+ description + ", owner=" + owner + ", photos=" + photos + ", recipes=" + recipes + ", reviews="
				+ reviews + ", benches=" + benches + ", cuisines=" + cuisines + "]";
	}
	
	
	
}