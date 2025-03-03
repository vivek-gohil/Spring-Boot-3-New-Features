package com.borntocode.main.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.borntocode.main.dto.ResponseDto;
import com.borntocode.main.service.IVoteService;

@RestController
@RequestMapping("voteapi")
public class VoteController {

	private IVoteService iVoteService;

	public VoteController(IVoteService iVoteService) {
		this.iVoteService = iVoteService;
	}

	@PostMapping
	public ResponseEntity<ResponseDto> vote(@RequestParam("age") int age) {
		this.iVoteService.vote(age);
		return ResponseEntity.status(HttpStatus.OK)
				.body(new ResponseDto("200", "Your vote is registored successfully"));
	}

}
