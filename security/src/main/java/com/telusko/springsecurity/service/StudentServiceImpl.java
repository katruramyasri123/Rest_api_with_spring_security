package com.telusko.springsecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.telusko.springsecurity.entities.Student;
import com.telusko.springsecurity.repository.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepo studentRepo;

  
	@Override
	public Student save(Student student) {
		return studentRepo.save(student);
	}

	public StudentRepo getStudentRepo() {
		return studentRepo;
	}

	public void setStudentRepo(StudentRepo studentRepo) {
		this.studentRepo = studentRepo;
	}

	@Override
	public Student update(Student student) {
		return studentRepo.save(student);
	}

	@Override
	public void delete(Student student) {
			studentRepo.delete(student);		
	}

	@Override
	public List<Student> findAll() {
		return studentRepo.findAll();
	}

}
