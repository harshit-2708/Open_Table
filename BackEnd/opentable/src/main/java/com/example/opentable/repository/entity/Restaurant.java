package com.example.opentable.repository.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
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
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int restaurantId;
	
	@Column
	private String restaurantName;
	
	@Column
	@Embedded
	private Address address;
	
	
	@Column
	private String gstIn;
	
	@Column 
	private String contact;
	
	@Column
	private boolean nonVeg;
	
	@Column
	private String description;
	 
	@Column
	private String openingTime;
	
	@Column
	private String closingTime;
	
	@Column
	private int ratingSum;
	
	@Column
	private int usersRated;
	
	@Column
	private String thumbnailPhoto;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "owner_id")
	private User owner;

	@OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
	private List<Photo> photos = new ArrayList<>();
	
	@OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
	private List<Recipe> recipes = new ArrayList<>();
	
	@OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
	private List<Review> reviews = new ArrayList<>();
	
	@OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
	private List<Bench> benches = new ArrayList<>();
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Cuisine> cuisines = new ArrayList<>();

	public Restaurant() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Restaurant(int restaurantId, String restaurantName, Address address, String gstIn, String contact,
			boolean nonVeg, String description, String openingTime, String closingTime, int ratingSum, int usersRated,
			String thumbnailPhoto, User owner, List<Photo> photos, List<Recipe> recipes, List<Review> reviews,
			List<Bench> benches, List<Cuisine> cuisines) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.address = address;
		this.gstIn = gstIn;
		this.contact = contact;
		this.nonVeg = nonVeg;
		this.description = description;
		this.openingTime = openingTime;
		this.closingTime = closingTime;
		this.ratingSum = ratingSum;
		this.usersRated = usersRated;
		this.thumbnailPhoto = thumbnailPhoto;
		this.owner = owner;
		this.photos = photos;
		this.recipes = recipes;
		this.reviews = reviews;
		this.benches = benches;
		this.cuisines = cuisines;
	}



	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
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

	public String getOpeningTime() {
		return openingTime;
	}

	public void setOpeningTime(String openingTime) {
		this.openingTime = openingTime;
	}

	public String getClosingTime() {
		return closingTime;
	}

	public void setClosingTime(String closingTime) {
		this.closingTime = closingTime;
	}

	public int getRatingSum() {
		return ratingSum;
	}

	public void setRatingSum(int ratingSum) {
		this.ratingSum = ratingSum;
	}

	public int getUsersRated() {
		return usersRated;
	}

	public void setUsersRated(int usersRated) {
		this.usersRated = usersRated;
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



	public String getThumbnailPhoto() {
		return thumbnailPhoto;
	}



	public void setThumbnailPhoto(String thumbnailPhoto) {
		this.thumbnailPhoto = thumbnailPhoto;
	}
	
}