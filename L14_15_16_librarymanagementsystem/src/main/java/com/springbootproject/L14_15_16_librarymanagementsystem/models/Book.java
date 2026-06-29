package com.springbootproject.L14_15_16_librarymanagementsystem.models;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //database handle autoincrement
	private int id;
	

	@Column(nullable = false)
	private String name;
	
	@Enumerated(value=EnumType.STRING)
	private Genre genre;
	
	//@Column(unique = true, nullable = false)
	@ManyToOne
	@JoinColumn
	@JsonIgnoreProperties("bookList") //to save it from infinite loop
	private Author myAuthor;
	
	@ManyToOne
	@JoinColumn
	@JsonIgnoreProperties(value={"bookList","transactionList"})
	private Student student;
	
	@OneToMany(mappedBy="book")
	@JsonIgnoreProperties(value={"book","student"}) //you can stop properties in book transaction list like that
	private List<Transaction> transactionList;
	
	@CreationTimestamp
	private Date createdOn;
	
	@UpdateTimestamp
	private Date UpdatedOn;
	


	
	
	

}
