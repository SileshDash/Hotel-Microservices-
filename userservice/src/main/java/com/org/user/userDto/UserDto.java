package com.org.user.userDto;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	private int userId;
	private String name;
	private String email;
	private String about;
	@Transient
	private List<Rating> ratings= new ArrayList<>();
}
