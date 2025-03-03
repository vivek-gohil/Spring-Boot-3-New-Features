package com.lms.books.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lms.books.constants.BooksConstants;
import com.lms.books.dto.BooksContactInfoDto;
import com.lms.books.dto.BooksDto;
import com.lms.books.dto.ResponseDto;
import com.lms.books.service.IBooksService;

import jakarta.validation.Valid;

@RestController
@Validated
@RequestMapping("/api")
public class BooksController {
	private final IBooksService iBooksService;

	private static final Logger logger = Logger.getLogger(BooksController.class.getName());

//	@Value("${build.version}")
//	private String buildVersion;

//    @Autowired
//    private BooksContactInfoDto booksContactInfoDto;

	@GetMapping("/hello")
	public String hello() {
		return "Hello from BooksController";
	}

	public BooksController(IBooksService iBooksService) {
		logger.info("Inside BooksController constructor");
		this.iBooksService = iBooksService;
	}

	@PostMapping("/create")
	public ResponseEntity<ResponseDto> createBookEntity(@Valid @RequestBody BooksDto booksDto) {
		logger.info("Inside createBookEntity method of BooksController");
		iBooksService.addBook(booksDto);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new ResponseDto(BooksConstants.STATUS_201, BooksConstants.MESSAGE_201));
	}

	@GetMapping("/fetch")
	public ResponseEntity<BooksDto> fetchBookEntity(@RequestParam Long bookId) {
		logger.info("Inside fetchBookEntity method of BooksController for bookId = " + bookId);
		BooksDto booksDto = iBooksService.fetchBook(bookId);
		return ResponseEntity.status(HttpStatus.OK).body(booksDto);
	}

	@PutMapping("/update")
	public ResponseEntity<ResponseDto> updateBookDetails(@Valid @RequestBody BooksDto booksDto) {
		boolean isUpdated = iBooksService.updateBook(booksDto);
		if (isUpdated) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseDto(BooksConstants.STATUS_200, BooksConstants.MESSAGE_200));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ResponseDto(BooksConstants.STATUS_417, BooksConstants.MESSAGE_417_UPDATE));
		}
	}

	@DeleteMapping("/delete")
	public ResponseEntity<ResponseDto> deleteBookEntity(@RequestParam Long bookId) {
		boolean isDeleted = iBooksService.deleteBook(bookId);
		if (isDeleted) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseDto(BooksConstants.STATUS_200, BooksConstants.MESSAGE_200));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ResponseDto(BooksConstants.STATUS_417, BooksConstants.MESSAGE_417_DELETE));
		}
	}

//	@GetMapping("/build-info")
//	public ResponseEntity<String> getBuildInfo() {
//		return ResponseEntity.status(HttpStatus.OK).body(buildVersion);
//	}
//
//	@GetMapping("/contact-info")
//	public ResponseEntity<BooksContactInfoDto> getContactInfo() {
//		return ResponseEntity.status(HttpStatus.OK).body(booksContactInfoDto);
//	}
}
