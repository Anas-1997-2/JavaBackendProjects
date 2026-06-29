package com.springbootproject.L14_15_16_librarymanagementsystem.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootproject.L14_15_16_librarymanagementsystem.models.Book;
import com.springbootproject.L14_15_16_librarymanagementsystem.models.Student;
import com.springbootproject.L14_15_16_librarymanagementsystem.models.Transaction;
import com.springbootproject.L14_15_16_librarymanagementsystem.models.TransactionType;

//Types of queries in Spring Data JPA
//
//1.Derived Queries (what you used)
//
//Defined by method names.
//
//Example1: List<>Transaction findByEmailAndStatusOrderByIdDesc(User user, Status status)

//example 2 Transaction findByTransactionId(String txnId);
//
// 2.JPQL Queries (@Query)
//
//You write JPQL manually.
//
//@Query("SELECT t FROM Transaction t WHERE t.student = :student")
//List<Transaction> findByStudent(@Param("student") Student student);
//
//
//3.Native Queries (@Query + nativeQuery = true)
//
//You write raw SQL manually.
//
//@Query(value = "SELECT * FROM transaction WHERE student_id = :studentId", nativeQuery = true)
//List<Transaction> findByStudentNative(@Param("studentId") int studentId);

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
	//Transaction findByTransactionId(int id);
	
		//List<Transaction>  findByStudent(Student student);
		
//		List<Transaction> findByStudentAndBook(Student student, Book book);
		
//		List<Transaction>  findByStudentOrderById(Student student);// order by on trasnction id primary key
		
		
		//		//Q. find the lastest  transaction with student book and  trasnaction status should be TRANSCTION TYPE ISSUE
		
		
		
		List<Transaction> findByStudentAndBookAndTransactionTypeOrderByIdDesc(Student student, Book book, TransactionType transactionType);
}
