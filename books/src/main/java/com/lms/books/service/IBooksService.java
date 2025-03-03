package com.lms.books.service;

import com.lms.books.dto.BooksDto;

public interface IBooksService {
    void addBook(BooksDto bookDto);
    BooksDto fetchBook(Long bookId);
    boolean updateBook(BooksDto bookDto);   
    boolean deleteBook(Long bookId);
}
