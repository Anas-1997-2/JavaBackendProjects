package com.springbootproject.L14_15_16_librarymanagementsystem.models;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class Transaction {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	
	private String transactionId; //manually to show public
	
	@Enumerated(value=EnumType.STRING)
	private TransactionStatus transactionStatus;
	
	@Enumerated(value=EnumType.STRING)
	private TransactionType transactionType;
	
	@ManyToOne
	@JoinColumn
	@JsonIgnoreProperties(value="transactionList")
	private Student student;
	
	@ManyToOne
	@JoinColumn
	@JsonIgnoreProperties(value="transactionList")
	private Book book;
	
	private int fine;
	
	@CreationTimestamp
	private Date createdOn;
	
	@UpdateTimestamp
	private Date updatedOn;

	
	
}
