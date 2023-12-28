package com.org.rating.service;

import java.util.List;

import com.org.rating.entity.Rating;

public interface RatingService {
	Rating createRating(Rating rating);
	List<Rating> getAllRatings();
	List<Rating> getRatingsByUserId(Integer userId);
	List<Rating> getratingByHotelId(String hotelId);
	
}
