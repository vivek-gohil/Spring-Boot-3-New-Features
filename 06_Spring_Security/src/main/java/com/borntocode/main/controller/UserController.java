package com.borntocode.main.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.borntocode.main.model.Customer;
import com.borntocode.main.repository.CustomerRepository;

@RestController
public class UserController {

	private final CustomerRepository customerRepository;
	private final PasswordEncoder passwordEncoder;

	public UserController(CustomerRepository customerRepository, PasswordEncoder passwordEncoder) {
		super();
		this.customerRepository = customerRepository;
		this.passwordEncoder = passwordEncoder;
		System.out.println("Overloaded constructor created");
	}

	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody Customer customer) {
		try {
			System.out.println("in registorUser");

			String hashPassword = passwordEncoder.encode(customer.getPwd());
			customer.setPwd(hashPassword);
			Customer savedCustomer = customerRepository.save(customer);

			if (savedCustomer.getId() > 0) {
				return ResponseEntity.status(HttpStatus.CREATED).body("Given user details are created successfully");
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User registration failed");
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("An Exception occured " + e.getMessage());
		}
	}
}
