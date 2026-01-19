package com.telusko.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.telusko.springsecurity.entities.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

}
