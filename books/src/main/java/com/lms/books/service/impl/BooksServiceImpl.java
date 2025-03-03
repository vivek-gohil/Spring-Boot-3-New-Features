package com.lms.books.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.lms.books.dto.BooksDto;
import com.lms.books.entity.Books;
import com.lms.books.exception.BookAlreadyExistsException;
import com.lms.books.exception.ResourceNotFoundException;
import com.lms.books.mapper.BooksMapper;
import com.lms.books.repository.BooksRepository;
import com.lms.books.service.IBooksService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BooksServiceImpl implements IBooksService{

    private final BooksRepository booksRepository;

    @Override
    public void addBook(BooksDto bookDto) {
    Books book = BooksMapper.mapToBooks(bookDto, new Books());
    Optional<Books> optionalBooks =  booksRepository.findById(bookDto.getBookId());        
    if(optionalBooks.isPresent()) {
        throw new BookAlreadyExistsException("Book with id "+bookDto.getBookId()+" already exists");
    }
    else 
        booksRepository.save(book);
    }

    @Override
    public BooksDto fetchBook(Long bookId) {
        Optional<Books> optionalBooks =  booksRepository.findById(bookId);
        if(optionalBooks.isPresent()) {
            return BooksMapper.mapToBooksDto(optionalBooks.get(), new BooksDto());
        }
        else {
            throw new ResourceNotFoundException("Book", "id", bookId.toString());
        }
    }

    @Override
    public boolean updateBook(BooksDto bookDto) {
        Optional<Books> optionalBooks =  booksRepository.findById(bookDto.getBookId());
        if(optionalBooks.isPresent()) {
            Books book = BooksMapper.mapToBooks(bookDto, optionalBooks.get());
            booksRepository.save(book);
            return true;
        }
        else {
            throw new ResourceNotFoundException("Book", "id", bookDto.getBookId().toString());
        }
    }

    @Override
    public boolean deleteBook(Long bookId) {
        Optional<Books> optionalBooks =  booksRepository.findById(bookId);
        if(optionalBooks.isPresent()) {
            booksRepository.deleteById(bookId);
            return true;
        }
        else {
            throw new ResourceNotFoundException("Book", "id", bookId.toString());
        }
    }

}
