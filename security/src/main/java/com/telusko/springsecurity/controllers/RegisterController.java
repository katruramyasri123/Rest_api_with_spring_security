package com.telusko.springsecurity.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.springsecurity.entities.User;
import com.telusko.springsecurity.service.UserPassword;

@RestController
public class RegisterController {
	@Autowired
	private UserPassword userPassword;
@PostMapping("/register")
	public User save(@RequestBody User user) {
	return  userPassword.register(user);
}
@PostMapping("/login")
public String login(@RequestBody User user) {
	return userPassword.login(user);
	
}
}
