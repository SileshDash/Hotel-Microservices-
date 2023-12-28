package com.org.rating.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.rating.entity.Rating;
import com.org.rating.repository.RatingRepo;
import com.org.rating.service.RatingService;
@Service
public class RatingServiceImpl implements RatingService {
	@Autowired
	private RatingRepo ratingRepo;

	@Override
	public Rating createRating(Rating rating) {
		
		return ratingRepo.save(rating);
	}

	@Override
	public List<Rating> getAllRatings() {
		
		return ratingRepo.findAll();
	}

	

	@Override
	public List<Rating> getRatingByHotelId(Integer hotelId) {
		
		return ratingRepo.findByHotelId(hotelId);
	}

	@Override
	public List<Rating> getRatingsByUserId(Integer userId) {
		
		return ratingRepo.findByUserId(userId);
	}

}
