package com.springbootproject.L14_15_16_librarymanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootproject.L14_15_16_librarymanagementsystem.createrequest.StudentCreateRequest;
import com.springbootproject.L14_15_16_librarymanagementsystem.models.Student;
import com.springbootproject.L14_15_16_librarymanagementsystem.repos.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository sr;

	public void createStudent(Student student) {
		sr.save(student);
		
	}

	public List<Student> getAllStudent() {
		return sr.findAll();
	}
	
	public Student getStudentById(int id) {
	return sr.findById(id).get();
	}

}
