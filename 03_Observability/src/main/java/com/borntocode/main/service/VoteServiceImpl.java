package com.borntocode.main.service;

import org.springframework.stereotype.Service;

import com.borntocode.main.exception.AgeNotValidException;

import io.micrometer.observation.annotation.Observed;

@Service
public class VoteServiceImpl implements IVoteService {

	@Observed(name = "vote")
	public void vote(int age) {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (age < 18)
			throw new AgeNotValidException();
	}

}
