package com.springbootproject.L14_15_16_librarymanagementsystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springbootproject.L14_15_16_librarymanagementsystem.createrequest.StudentCreateRequest;
import com.springbootproject.L14_15_16_librarymanagementsystem.models.Student;
import com.springbootproject.L14_15_16_librarymanagementsystem.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@PostMapping(value="/createstudent")
	public void createStudent(@RequestBody StudentCreateRequest studentCreateRequest) {
		
		studentService.createStudent(studentCreateRequest.to());
		
	}
	
	@GetMapping(value="/student/all")
	public List<Student> getAllStudent() {
		
		return studentService.getAllStudent();
		
	}
	
	@GetMapping(value="/student/{id}")
	public Student getStudentById(@PathVariable("id") int id) {
		
		return studentService.getStudentById(id);
		
	}

}
