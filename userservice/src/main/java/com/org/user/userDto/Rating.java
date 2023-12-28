package com.org.user.userDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Rating {
	private String ratingId;
	private int hotelId;
	private String rating;
	private String remarks;
}
