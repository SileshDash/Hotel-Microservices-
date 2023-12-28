package com.org.hotel.serviceImpl;

import java.lang.module.ResolutionException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.hotel.entity.Hotel;
import com.org.hotel.exception.ResourceNotFoundException;
import com.org.hotel.repository.HotelRepo;
import com.org.hotel.service.HotelService;
@Service
public class HotelServiceImpl implements HotelService {
	@Autowired
	private HotelRepo hotelRepo;

	@Override
	public Hotel createHotel(Hotel hotel) {
		
		return this.hotelRepo.save(hotel);
	}

	@Override
	public List<Hotel> getAllHotels() {
		
		return this.hotelRepo.findAll();
	}

	@Override
	public Hotel getHotelById(Integer hotelId) {
			Hotel hotel=this.hotelRepo.findById(hotelId).orElseThrow(() -> new ResourceNotFoundException("Hotel", "id", hotelId));
		return hotel;
		
      }

	@Override
	public void deleteHotel(Integer hotelId) {
		Hotel hotel = this.hotelRepo.findById(hotelId).orElseThrow(() -> new ResourceNotFoundException("Hotel", "id", hotelId));
		hotelRepo.deleteById(hotelId);
	}

	



}
