package com.org.hotel.service;

import java.util.List;

import com.org.hotel.entity.Hotel;

public interface HotelService {
	Hotel createHotel(Hotel hotel);
	List<Hotel> getAllHotels();
	Hotel getHotelById(Integer hotelId);
	void deleteHotel(Integer hotelId);
}
