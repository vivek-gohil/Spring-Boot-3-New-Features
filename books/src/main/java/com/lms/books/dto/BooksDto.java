package com.lms.books.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data // Lombok annotation to create all the getters, setters, equals, hash, and toString methods
public class BooksDto {
    @NotNull(message = "BookId can not be a null or empty")
    private Long bookId;
    @NotEmpty(message = "BookName cannot be null or empty")   
    private String bookName;
    @NotEmpty(message = "Author cannot be null or empty")
    private String author;
    @NotEmpty(message = "Genre cannot be null or empty")
    private String genre;
    @NotNull(message = "IsIssuable cannot be null or empty")
    private Boolean isIssuable;
    @NotNull(message = "IsAvailable cannot be null or empty")
    private Boolean isAvailable;
}
