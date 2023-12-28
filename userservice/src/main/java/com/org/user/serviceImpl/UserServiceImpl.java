package com.org.user.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.user.entity.User;
import com.org.user.exception.ResourceNotFoundException;
import com.org.user.repository.UserRepo;
import com.org.user.service.UserService;
import com.org.user.userDto.UserDto;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDto createUser(UserDto userDto) {
		User user = this.userDtoToUser(userDto);
		User savedUser= this.userRepo.save(user);
		return this.userToUserDto(savedUser);
	}

	@Override
	public List<UserDto> getAllUser() {
		List<User> users = this.userRepo.findAll();
		List<UserDto> dtos = users.stream().map(user->this.userToUserDto(user)).collect(Collectors.toList());
		return dtos;
	}

	public UserDto userToUserDto(User user) {
		UserDto userDto = this.modelMapper.map(user, UserDto.class);
		return userDto;
	}
	public User userDtoToUser(UserDto userDto) {
		User user = this.modelMapper.map(userDto, User.class);
		return user;
	}

	@Override
	public UserDto getUserById(Integer userId) {
		User user=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("user", "id", userId));
		return this.modelMapper.map(user, UserDto.class);
	}



	@Override
	public void deleteUser(Integer UserId) {
		// TODO Auto-generated method stub
		User user = this.userRepo.findById(UserId).orElseThrow(()->new ResourceNotFoundException("user", "id", UserId));
		userRepo.delete(user);
	}

	@Override
	public UserDto updateUser(Integer userId, UserDto userDto) {
		// TODO Auto-generated method stub
		return null;
	}	
  }

