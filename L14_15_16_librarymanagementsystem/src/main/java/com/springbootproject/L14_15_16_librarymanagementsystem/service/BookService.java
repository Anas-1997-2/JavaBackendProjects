package com.springbootproject.L14_15_16_librarymanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootproject.L14_15_16_librarymanagementsystem.createrequest.BookCreateRequest;
import com.springbootproject.L14_15_16_librarymanagementsystem.models.Author;
import com.springbootproject.L14_15_16_librarymanagementsystem.models.Book;
import com.springbootproject.L14_15_16_librarymanagementsystem.repos.AuthorRepository;
import com.springbootproject.L14_15_16_librarymanagementsystem.repos.BookRepository;

@Service
public class BookService {
	
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	AuthorService authorService;

	public boolean createBook(Book book) {
	
		Author author=authorService.CreateOrGetAuthor(book.getMyAuthor()) ;
		book.setMyAuthor(author); //we set owning side(book with joincolumn) so foriegn key set automatcally
		bookRepository.save(book);
		return true;
	}

	public List<Book> getAllBooks() {
	  List<Book> x=bookRepository.findAll();
	  return x;
		
	}

	public Book getBookById(int id) {
		return bookRepository.findById(id).get();
	}

	
}
