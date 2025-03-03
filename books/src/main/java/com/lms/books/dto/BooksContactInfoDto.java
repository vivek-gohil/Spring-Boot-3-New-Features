package com.lms.books.dto;

import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BooksContactInfoDto {
	private String message;
	private Map<String, String> contactDetails;
	private List<String> onCallSupport;
}
