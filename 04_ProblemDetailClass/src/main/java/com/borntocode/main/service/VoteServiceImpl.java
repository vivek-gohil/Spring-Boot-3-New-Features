package com.borntocode.main.service;

import org.springframework.stereotype.Service;

import com.borntocode.main.exception.AgeNotValidException;

@Service
public class VoteServiceImpl implements IVoteService {

	@Override
	public void vote(int age) {
		if (age < 18)
			throw new AgeNotValidException();
	}

}
