package com.example.opentable.transport.dto;

import java.util.Date;


public class ReviewDto {
	
	private int reviewId;

	private String review;

	private int rating;

	private Date timestamp;

	public ReviewDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReviewDto(int reviewId, String review, int rating, Date timestamp) {
		super();
		this.reviewId = reviewId;
		this.review = review;
		this.rating = rating;
		this.timestamp = timestamp;
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	
}
