package com.springbootproject.L14_15_16_librarymanagementsystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springbootproject.L14_15_16_librarymanagementsystem.service.TransactionService;

@RestController
public class TransactionController {
	
	@Autowired
	TransactionService ts;
	
	@GetMapping(value="/transaction/issue")
	public String issuBook(@RequestParam("sid") int studentId,@RequestParam("bid") int bookId) throws Exception {
		return ts.issueBook(studentId, bookId);
	}
	
	@GetMapping(value="/transaction/return")
	public String returnBook(@RequestParam("sid") int studentId,@RequestParam("bid") int bookId) throws Exception {
	  	return ts.returnBook(studentId, bookId);
	}

}
