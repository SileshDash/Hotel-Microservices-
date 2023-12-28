package com.org.rating.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document("user_rating")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rating {
	@Id
	private String ratingId;
	private int userId;
	private int hotelId;
	private String rating;
	private String remarks;

}
