package com.telusko.springsecurity.service;

import java.util.List;

import com.telusko.springsecurity.entities.Student;

public interface StudentService {

	public Student save(Student student);
	public Student update(Student student);
	public void delete(Student student);
	public List<Student> findAll();
}
