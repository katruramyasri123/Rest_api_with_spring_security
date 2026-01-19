package com.telusko.springsecurity.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.springsecurity.entities.Student;
import com.telusko.springsecurity.service.StudentService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
//@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService studentService;
	@PostMapping("/student")
	public Student saveStudents(@RequestBody Student student) {
		return studentService.save(student);	
	}
	@GetMapping("/student")
	public List<Student> getStudents(){
		return studentService.findAll();
	}
	@GetMapping("/csrf")
	public CsrfToken getCsrfToken(HttpServletRequest request) {
		return (CsrfToken) request.getAttribute("_csrf");
	}
	

}
