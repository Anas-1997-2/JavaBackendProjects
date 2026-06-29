package com.springbootproject.L14_15_16_librarymanagementsystem.service;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.springbootproject.L14_15_16_librarymanagementsystem.models.Book;
import com.springbootproject.L14_15_16_librarymanagementsystem.models.Student;
import com.springbootproject.L14_15_16_librarymanagementsystem.models.Transaction;
import com.springbootproject.L14_15_16_librarymanagementsystem.models.TransactionStatus;
import com.springbootproject.L14_15_16_librarymanagementsystem.models.TransactionType;
import com.springbootproject.L14_15_16_librarymanagementsystem.repos.TransactionRepository;

@Service
public class TransactionService {

//	student.book.limit=2
//  book.return.days=7
//	book.fine.day=1
//			

	@Value("${student.book.limit}")
	int studentBookLimit;

	@Value("${book.return.days}")
	int bookReturnDays;

	@Value("${book.fine.day}")
	int finePerDay;

	@Autowired
	TransactionRepository tr;

	@Autowired
	StudentService ss;

	@Autowired
	BookService bs;

	// 1st method - issue book
	// 1. student is present or not
	// 2. Student book limit or max book to be issued
	// 3. find the book is present or available or not
	// 4. create a txn with pending status
	// 5. Make the book unvailable and assign it to a student
	// 6. Update the txn was successfull and respond the msg

	public String issueBook(int sid, int bid) throws Exception {
		Student student=ss.getStudentById(sid);
		if(student==null) {
			throw new Exception("unable to isse book , no student ");
		}
		
		if(student.getBookList().size()>=studentBookLimit) {
			throw new Exception("unable to isse book , limit crossed");
		}
		
		Book book=bs.getBookById(bid);
		if(book==null) {
			throw new Exception("unable to isse book , no book");
		}
		
		if(book.getStudent()!=null) {
			throw new Exception("unable to isse book , already issued");
		}
		
		Transaction transaction=Transaction.builder().
				transactionStatus(TransactionStatus.PENDING).
				transactionType(TransactionType.ISSUE).student(student).
				book(book).transactionId(UUID.randomUUID().toString()).build();
		
		try {
			book.setStudent(student);//setting owning side
			//student.getBookList().add(book);//setting inverseside //not manadatory after saving database do this for you but not immediately set
			bs.createBook(book); //save also update record
			transaction.setTransactionStatus(TransactionStatus.SUCCESS);
			tr.save(transaction);
		}catch(Exception e) {
			book.setStudent(null);
			bs.createBook(book);
			transaction.setTransactionStatus(TransactionStatus.FAILED);
			tr.save(transaction);
		}
		
		return transaction.getTransactionId() + "Issue method";
		
	}
	
	public String returnBook(int sid,int bid) throws Exception {
		// 2nd method - return book
		// check both book and studen is present
		// 1. to check whether the book is assigned to the student or not ?
		// 2. check the return date and calculate the fine if any then update txn
		// 3. create a txn with pending status
		// 4. Make the book available and or make the student id to null
		// 5. send succcesss msg
		Student student=ss.getStudentById(sid);
		Book book=bs.getBookById(bid);
		
		if(student==null || book==null || book.getStudent()==null || book.getStudent().getStudentId()!=sid) {
			throw new Exception("cant return book");
		}
		
		// to calculate the fine u need to find the issue date
				// transaction u will have to find the book issue details

				// Q. find the lastest transaction with student book and trasaction status
				// should be TRANSCTION TYPE ISSUE

		List<Transaction> issuedTxns = tr
				.findByStudentAndBookAndTransactionTypeOrderByIdDesc(student, book, TransactionType.ISSUE);

		Transaction issueTnx = issuedTxns.get(0);

		long issueTimeInMs = issueTnx.getUpdatedOn().getTime();
		long currentTimeInMs = System.currentTimeMillis();

		long timeDiff = currentTimeInMs - issueTimeInMs;

		long diffInDays = TimeUnit.DAYS.convert(timeDiff, TimeUnit.MILLISECONDS);

		int fine = 0;
		if (diffInDays > bookReturnDays) {
			fine = (int) ((diffInDays - bookReturnDays) * finePerDay);

		}
		
		Transaction transaction=Transaction.builder().
				transactionStatus(TransactionStatus.PENDING).
				transactionType(TransactionType.RETURN).student(student).fine(fine).
				book(book).transactionId(UUID.randomUUID().toString()).build();
		
		try {
			book.setStudent(null);
			bs.createBook(book); //update database record with save()
			transaction.setTransactionStatus(TransactionStatus.SUCCESS);
			tr.save(transaction);
			
		}catch(Exception e) {
			book.setStudent(student);
			bs.createBook(book); //update database record with save()
			transaction.setTransactionStatus(TransactionStatus.FAILED);
			tr.save(transaction);
		}
		
		return transaction.getTransactionId(); //manual id to show public
		
	}

}
