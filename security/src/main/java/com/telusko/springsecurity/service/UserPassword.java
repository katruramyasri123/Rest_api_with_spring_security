package com.telusko.springsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.telusko.springsecurity.entities.User;
import com.telusko.springsecurity.repository.UserRepo;

@Service
public class UserPassword {
	@Autowired
	 AuthenticationManager authManager;
    @Autowired
	private UserRepo userRepo;
	 @Autowired
	 private PasswordEncoder passwordEncoder;
	 @Autowired
	 private JwtService jwtService;
	public User register(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepo.save(user);
	}
	public  String login(User user) {
		
		org.springframework.security.core.Authentication authentication =authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
		if(authentication.isAuthenticated()) {
			return jwtService.generateToken(user.getUsername());
			
		}
		else {
			return "fail";
		}
	}
}
