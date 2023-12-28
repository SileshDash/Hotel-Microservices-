package com.org.user.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public UserDto createUser(UserDto userDto) {
		User user = this.userDtoToUser(userDto);
		User savedUser= this.userRepo.save(user);
		return this.userToUserDto(savedUser);
	}

	@Override
	public List<UserDto> getAllUser() {
		List<User> users = this.userRepo.findAll();
		 List<UserDto> userDtos = new ArrayList<>();
		    for (User user : users) {
		        // Fetch ratings for each user individually
		        ArrayList rating = restTemplate.getForObject("http://localhost:8081/api/rating/user/" +user.getUserId(),ArrayList.class);
		        UserDto userDto = userToUserDto(user);
		        userDto.setRatings(rating);
		        userDtos.add(userDto);
		    }
		
		//List<UserDto> dtos = users.stream().map(user->this.userToUserDto(user)).collect(Collectors.toList());
		return userDtos;
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
		ArrayList rating = restTemplate.getForObject("http://localhost:8081/api/rating/user/"+user.getUserId(), ArrayList.class);
			UserDto userdto = this.modelMapper.map(user, UserDto.class);
			userdto.setRatings(rating);
			return userdto;
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

