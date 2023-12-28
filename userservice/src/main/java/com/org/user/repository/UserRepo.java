package com.org.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.user.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
