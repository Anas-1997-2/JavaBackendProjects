package com.springbootproject.L14_15_16_librarymanagementsystem.createrequest;
import com.springbootproject.L14_15_16_librarymanagementsystem.models.Author;
import com.springbootproject.L14_15_16_librarymanagementsystem.models.Book;
import com.springbootproject.L14_15_16_librarymanagementsystem.models.Genre;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;


public class BookCreateRequest {

	@NotBlank // we are using jakarta.validation here as it not an entity.
	private String name;
	
	
    private Genre genre;
	
	@NotBlank
	private String authorName;
	
	@NotBlank
	@Email
	private String email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Book to() {
		Author author=Author.builder().name(authorName).email(email).build();
		
		Book book=Book.builder().name(name).genre(genre).myAuthor(author).build();
		
		return book;
		
	}
	
	
}
