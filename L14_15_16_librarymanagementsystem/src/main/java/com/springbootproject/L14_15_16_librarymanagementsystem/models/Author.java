package com.springbootproject.L14_15_16_librarymanagementsystem.models;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Author {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int authorId;
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable=false,unique=true)
	private String email;
	
	@OneToMany(mappedBy="myAuthor")
	@JsonIgnoreProperties(value="myAuthor")
	private List<Book> bookList;
	
	@CreationTimestamp
	private Date createdOn;
	
	@UpdateTimestamp
	private Date updateOn;
	

}
