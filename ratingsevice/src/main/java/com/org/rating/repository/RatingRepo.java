package com.org.rating.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.org.rating.entity.Rating;
@Repository
public interface RatingRepo extends MongoRepository<Rating, String> {
	
	List<Rating> findByUserId(Integer userId);
	List<Rating> findByHotelId(String hotelId);
}
