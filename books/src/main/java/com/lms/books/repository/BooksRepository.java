package com.lms.books.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lms.books.entity.Books;

@Repository
public interface BooksRepository extends JpaRepository<Books, Long> {

}
