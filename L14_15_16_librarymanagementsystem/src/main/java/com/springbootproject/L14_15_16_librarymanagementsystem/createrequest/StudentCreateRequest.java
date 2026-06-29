package com.springbootproject.L14_15_16_librarymanagementsystem.createrequest;

import com.springbootproject.L14_15_16_librarymanagementsystem.models.Student;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class StudentCreateRequest  {
	
	@NotBlank
	private String name;
	
	@NotBlank
	private int age;
	
	@NotBlank
	@Email
	private String email;
	
	@NotBlank
	private String phoneNo;
	
	public Student to() {
		Student student=Student.builder().name(name).phoneNo(phoneNo).email(email).age(age).build();
		return student;
	}
	
	

}
