package com.org.rating.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.rating.entity.Rating;
import com.org.rating.service.RatingService;

@RestController
@RequestMapping("/api/rating")
public class RatingController {
	@Autowired
	private RatingService ratingService;
	@PostMapping("/save")
	public ResponseEntity<Rating> create(@RequestBody Rating rating){
		return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.createRating(rating));
	}
	@GetMapping("/get")
	public ResponseEntity<List<Rating>> getRatings(){
		return ResponseEntity.ok(ratingService.getAllRatings());
	}
	@GetMapping("/hotel/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable Integer hotelId){
		return ResponseEntity.ok(ratingService.getRatingByHotelId(hotelId));	
}
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable Integer userId){
		return ResponseEntity.ok(ratingService.getRatingsByUserId(userId));
		}
}