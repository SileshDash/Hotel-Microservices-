package com.org.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.hotel.entity.Hotel;

public interface HotelRepo extends JpaRepository<Hotel, Integer> {

}
