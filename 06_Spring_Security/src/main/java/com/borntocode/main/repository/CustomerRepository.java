package com.borntocode.main.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.borntocode.main.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
	Optional<Customer> findByEmail(String email);
}
