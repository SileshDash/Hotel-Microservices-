package com.org.user.controller;


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

import com.org.user.entity.User;
import com.org.user.service.UserService;
import com.org.user.userDto.UserDto;
@RestController
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	private UserService userService;
	@PostMapping("/save")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
		UserDto createdUser = userService.createUser(userDto);
		return new ResponseEntity<UserDto>(createdUser, HttpStatus.CREATED);
}
	@GetMapping("/get")
	public ResponseEntity<List<UserDto>> getAllUser(){
		List<UserDto> allUser = userService.getAllUser();
		return ResponseEntity.ok(allUser);
	}
	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable Integer userId) {
		userService.deleteUser(userId);
		return new ResponseEntity(Map.of("message","delete sucessfully"),HttpStatus.OK);
	}
	@GetMapping("/get/{userId}")
	public ResponseEntity<UserDto> getUserById(@PathVariable Integer userId){
		UserDto user = userService.getUserById(userId);
		return ResponseEntity.ok(user);
}
}
