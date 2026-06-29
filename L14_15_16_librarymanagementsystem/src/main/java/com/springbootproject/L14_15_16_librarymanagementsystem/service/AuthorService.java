package com.springbootproject.L14_15_16_librarymanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootproject.L14_15_16_librarymanagementsystem.models.Author;
import com.springbootproject.L14_15_16_librarymanagementsystem.repos.AuthorRepository;

@Service
public class AuthorService {
	
	@Autowired
	AuthorRepository authorRepo;

	public Author CreateOrGetAuthor(Author author) {
		
		Author authorFromDB = authorRepo.findAuthor(author.getEmail());

        if(authorFromDB == null){
            authorFromDB = authorRepo.save(author);
        }

        return authorFromDB;
	}
	
	

}
