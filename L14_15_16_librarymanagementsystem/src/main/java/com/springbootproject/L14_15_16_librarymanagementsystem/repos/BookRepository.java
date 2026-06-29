package com.springbootproject.L14_15_16_librarymanagementsystem.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootproject.L14_15_16_librarymanagementsystem.models.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

}
