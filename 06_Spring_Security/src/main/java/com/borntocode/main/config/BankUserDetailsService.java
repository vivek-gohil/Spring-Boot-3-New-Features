package com.borntocode.main.config;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.borntocode.main.model.Customer;
import com.borntocode.main.repository.CustomerRepository;

@Service
public class BankUserDetailsService implements UserDetailsService {

	private final CustomerRepository customerRepository;

	public BankUserDetailsService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Customer customer = customerRepository.findByEmail(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Details Not Found For User " + username));

		List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(customer.getRole()));
		UserDetails userDetails = new User(customer.getEmail(), customer.getPwd(), authorities);
		return userDetails;
	}

}
