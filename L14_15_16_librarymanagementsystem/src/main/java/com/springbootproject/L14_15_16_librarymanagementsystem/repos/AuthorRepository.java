package com.springbootproject.L14_15_16_librarymanagementsystem.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springbootproject.L14_15_16_librarymanagementsystem.models.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
	/** Custom queries
     * 1. JPQL - Java persistence query language (format which executes query considering java classes / objects)
     * 2. Native query - Format which executes query considering your sql tables / relations
     */

    @Query(value = "select a from Author a where a.email = :email")
    Author findAuthor(String email);

//    @Query(value = "select a from Author a where a.name = :name and a.email = ?2")
//    Author findAuthorByNameAndEmail(String name, String email);
//
//    @Query(value = "select * from author where author_id = ?1", nativeQuery = true)
//    Author findAuthorById2(int id);

}
