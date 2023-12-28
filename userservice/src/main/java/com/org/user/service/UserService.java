package com.org.user.service;

import java.util.List;


import com.org.user.userDto.UserDto;

public interface UserService {
	UserDto createUser(UserDto userDto);
	List<UserDto> getAllUser();
	UserDto getUserById(Integer userId);
	UserDto updateUser(Integer userId,UserDto userDto);
	void deleteUser(Integer UserId);

}
