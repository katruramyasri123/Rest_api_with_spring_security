package com.telusko.springsecurity.controllers;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class HomeController {
	@GetMapping("/")
	public String getHome(HttpServletRequest request) {
		return "welcome"+request.getSession().getId();
	}

}
