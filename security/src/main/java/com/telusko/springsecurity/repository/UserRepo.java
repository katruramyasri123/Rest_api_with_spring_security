package com.telusko.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.telusko.springsecurity.entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	public User findByUsername(String username);

}
