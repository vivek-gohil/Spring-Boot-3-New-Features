package com.borntocode.main.exception;

import java.net.URI;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(AgeNotValidException.class)
	public ResponseEntity<ProblemDetail> handleAgeNotValidException(AgeNotValidException ageNotValidException) {
		ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		problemDetail.setTitle("Age Not Valid Exception");
		problemDetail.setDetail("Age must be > 18");
		problemDetail.setType(URI.create("http://localhost:9091/errors"));
		problemDetail.setProperty("host", "localhost");
		problemDetail.setProperty("port", 8080);

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(problemDetail);
	}
}
