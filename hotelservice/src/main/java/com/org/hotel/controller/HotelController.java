package com.org.hotel.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.hotel.entity.Hotel;
import com.org.hotel.service.HotelService;
@RestController
@RequestMapping("/api/hotel")
public class HotelController {
	@Autowired
	private HotelService hotelService;
	@PostMapping("/save")
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
		Hotel createdHotel = this.hotelService.createHotel(hotel);
		return new ResponseEntity<Hotel>(createdHotel, HttpStatus.CREATED);
	}
	@GetMapping("/get")
	public ResponseEntity<List<Hotel>> getAllHotel(){
		List<Hotel> allHotels = this.hotelService.getAllHotels();
		return new ResponseEntity<List<Hotel>> (allHotels, HttpStatus.OK);
	}
	@GetMapping("/get/{hotelId}")
	public ResponseEntity<Hotel> getHotelById(@PathVariable Integer hotelId){
		Hotel hotel = this.hotelService.getHotelById(hotelId);
		return new ResponseEntity<Hotel>(hotel, HttpStatus.OK);
	}
	@DeleteMapping("/delete/{hotelId}")
		public ResponseEntity<?> deleteById(@PathVariable Integer hotelId){
		this.hotelService.deleteHotel(hotelId);
		return new ResponseEntity(Map.of("message","delete sucessfully"),HttpStatus.OK);
	}
}
