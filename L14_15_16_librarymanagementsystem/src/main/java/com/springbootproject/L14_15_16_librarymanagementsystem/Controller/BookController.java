package com.springbootproject.L14_15_16_librarymanagementsystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.springbootproject.L14_15_16_librarymanagementsystem.createrequest.BookCreateRequest;
import com.springbootproject.L14_15_16_librarymanagementsystem.models.Book;
import com.springbootproject.L14_15_16_librarymanagementsystem.service.BookService;

@RestController
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@PostMapping(value="/createbook")
	public boolean createBook(@RequestBody BookCreateRequest bookCreateRequest) {
		return bookService.createBook(bookCreateRequest.to());
	}
	
	@GetMapping(value="/book/all")
	public List<Book> getAllBooks() {
		return bookService.getAllBooks();
	}
	
	@GetMapping(value="/book/{id}")
	public Book getBookById(@PathVariable("id")int id) {
		return bookService.getBookById(id);
	}

}
