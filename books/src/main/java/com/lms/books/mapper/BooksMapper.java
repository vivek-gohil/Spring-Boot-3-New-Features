package com.lms.books.mapper;

import com.lms.books.dto.BooksDto;
import com.lms.books.entity.Books;

public class BooksMapper {
    public static BooksDto mapToBooksDto(Books books, BooksDto booksDto) {
        booksDto.setBookId(books.getBookId());
        booksDto.setBookName(books.getBookName());
        booksDto.setAuthor(books.getAuthor());
        booksDto.setGenre(books.getGenre());
        booksDto.setIsIssuable(books.getIsIssuable());
        booksDto.setIsAvailable(books.getIsAvailable());
        return booksDto;
    }

    public static Books mapToBooks(BooksDto booksDto, Books books) {
        books.setBookId(booksDto.getBookId());
        books.setBookName(booksDto.getBookName());
        books.setAuthor(booksDto.getAuthor());
        books.setGenre(booksDto.getGenre());
        books.setIsIssuable(booksDto.getIsIssuable());
        books.setIsAvailable(booksDto.getIsAvailable());
        return books;
    }
}
