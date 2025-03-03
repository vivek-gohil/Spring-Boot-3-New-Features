package com.borntocode.main.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.password.CompromisedPasswordChecker;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.password.HaveIBeenPwnedRestApiPasswordChecker;

import static org.springframework.security.config.Customizer.withDefaults;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {
//Step 1
//	@Bean
//	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//		http.authorizeHttpRequests((request) -> request.anyRequest().authenticated());
//		http.formLogin(withDefaults());
//		http.httpBasic(withDefaults());
//		return http.build();
//	}

//Step 2 = permitAll() . denyAll() method example
// 	@Bean	
//	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//		http.authorizeHttpRequests((request) -> request.anyRequest().denyAll());
//		http.formLogin(withDefaults());
//		http.httpBasic(withDefaults());
//		return http.build();
//	}

//Step 3 = Modifying the security config code as per our custom requirements
// 	@Bean	
//	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//		http.authorizeHttpRequests((request) -> request
//				.requestMatchers("/myAccount", "myBalance", "/myLoans", "/myCards").authenticated()
//				.requestMatchers("/notices","/contact","/error").permitAll()
//		);
//		http.formLogin(withDefaults());
//		http.httpBasic(withDefaults());
//		return http.build();
//	}

//Step 4 = How to disable the formLogin and HttpBasic authantication
//	@Bean
//	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//		http.authorizeHttpRequests(
//				(request) -> request.requestMatchers("/myAccount", "myBalance", "/myLoans", "/myCards").authenticated()
//						.requestMatchers("/notices", "/contact", "/error").permitAll());
//		http.formLogin(formLoginConfigr -> {
//			formLoginConfigr.disable();
//		});
//		http.httpBasic(httpBasicConig -> {
//			httpBasicConig.disable();
//		});
//		return http.build();
//	}
//Step 5 = Back to original
//	@Bean
//	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//		http.authorizeHttpRequests(
//				(request) -> request.requestMatchers("/myAccount", "myBalance", "/myLoans", "/myCards").authenticated()
//						.requestMatchers("/notices", "/contact", "/error").permitAll());
//		http.formLogin(withDefaults());
//		http.httpBasic(withDefaults());
//		return http.build();
//	}
//Step 6 = Configuring user using InMemoryUserDetailsManager - without password encoder
//	@Bean
//	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//		System.out.println("in defaultSecurityFilterChain");
//		http.authorizeHttpRequests(
//				(request) -> request.requestMatchers("/myAccount", "myBalance", "/myLoans", "/myCards").authenticated()
//						.requestMatchers("/notices", "/contact", "/error").permitAll());
//		http.formLogin(withDefaults());
//		http.httpBasic(withDefaults());
//		return http.build();
//	}
//
//	@Bean
//	public UserDetailsService userDetailsService() {
//		System.out.println("in userDetailsService");
//		UserDetails user = User.withUsername("user").password("{noop}12345").authorities("read").build();
//		UserDetails admin = User.withUsername("admin").password("{noop}54321").authorities("admin").build();
//
//		return new InMemoryUserDetailsManager(user, admin);
//	}

//Step 7 = Configuring PasswordEncoder using PasswordEncoderFactories
//	@Bean
//	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//		System.out.println("in defaultSecurityFilterChain");
//		http.authorizeHttpRequests(
//				(request) -> request.requestMatchers("/myAccount", "myBalance", "/myLoans", "/myCards").authenticated()
//						.requestMatchers("/notices", "/contact", "/error").permitAll());
//		http.formLogin(withDefaults());
//		http.httpBasic(withDefaults());
//		return http.build();
//	}
//
//	@Bean
//	public UserDetailsService userDetailsService() {
//		System.out.println("in userDetailsService");
//		UserDetails user = User.withUsername("user").password("{noop}12345").authorities("read").build();
//		UserDetails admin = User.withUsername("admin")
//				.password("{bcrypt}$2a$12$GQin5l0.vlADdgUHFcR8XOdauf7uPNfjh2urHay3DUfrhDHGJn6YW").authorities("admin")
//				.build();
//
//		return new InMemoryUserDetailsManager(user, admin);
//	}
//
//	// https://bcrypt-generator.com/
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//	}

//Step 8 = CompromisedPasswordChecke - Set strong passwords 
//	@Bean
//	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//		System.out.println("in defaultSecurityFilterChain");
//		http.authorizeHttpRequests(
//				(request) -> request.requestMatchers("/myAccount", "myBalance", "/myLoans", "/myCards").authenticated()
//						.requestMatchers("/notices", "/contact", "/error").permitAll());
//		http.formLogin(withDefaults());
//		http.httpBasic(withDefaults());
//		return http.build();
//	}
//
//	@Bean
//	public UserDetailsService userDetailsService() {
//		System.out.println("in userDetailsService");
//		UserDetails user = User.withUsername("user").password("{noop}Bahubali@2010").authorities("read").build();
//		UserDetails admin = User.withUsername("admin")
//				.password("{bcrypt}$2a$12$DH3h3C7QyaniWhsTKfgv3u4b9p8Vnimt5cwsMIvimBFUADSZmeBda").authorities("admin")
//				.build();
//
//		return new InMemoryUserDetailsManager(user, admin);
//	}
//
//	// https://bcrypt-generator.com/
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//	}
//
//	@Bean
//	public CompromisedPasswordChecker compromisedPasswordChecker() {
//		return new HaveIBeenPwnedRestApiPasswordChecker();
//	}

//Step 9 = Using JdbcUserDetailsManager to perform the authentication - Uses Default Spring Schema
// Go to pom.xm and add 3 dependency 
//1. JDBC API
//2. MySQL Driver
//3. Spring Data JPA
//	@Bean
//	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//		System.out.println("in defaultSecurityFilterChain");
//		http.authorizeHttpRequests(
//				(request) -> request.requestMatchers("/myAccount", "myBalance", "/myLoans", "/myCards").authenticated()
//						.requestMatchers("/notices", "/contact", "/error").permitAll());
//		http.formLogin(withDefaults());
//		http.httpBasic(withDefaults());
//		return http.build();
//	}
//
//	@Bean
//	public UserDetailsService userDetailsService(DataSource dataSource) {
//		return new JdbcUserDetailsManager(dataSource);
//	}
//
//	// https://bcrypt-generator.com/
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//	}
//
//	@Bean
//	public CompromisedPasswordChecker compromisedPasswordChecker() {
//		return new HaveIBeenPwnedRestApiPasswordChecker();
//	}

//Step 10 = Using Custom Table	
// Create new table - refer scripts.sql file from resources folder
// Create new model class = Customer.java
// Create new repository interface = CustomerRepository.java
// Create new config class = BankUserDetailsService.java
//	@Bean
//	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//		System.out.println("in defaultSecurityFilterChain");
//		http.authorizeHttpRequests(
//				(request) -> request.requestMatchers("/myAccount", "myBalance", "/myLoans", "/myCards").authenticated()
//						.requestMatchers("/notices", "/contact", "/error" , "/register" ).permitAll());
//		http.formLogin(withDefaults());
//		http.httpBasic(withDefaults());
//		return http.build();
//	}
//
//	// https://bcrypt-generator.com/
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//	}
//
//	@Bean
//	public CompromisedPasswordChecker compromisedPasswordChecker() {
//		return new HaveIBeenPwnedRestApiPasswordChecker();
//	}
	
//Step 11 = New User Registration
//To  Disable the CSRF
	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		System.out.println("in defaultSecurityFilterChain");
		http.csrf(csrfConf -> csrfConf.disable())
  				.authorizeHttpRequests((request) -> request
						.requestMatchers("/myAccount", "myBalance", "/myLoans", "/myCards").authenticated()
						.requestMatchers("/notices", "/contact", "/error", "/register").permitAll());
		http.formLogin(withDefaults());
		http.httpBasic(withDefaults());
		return http.build();
	}

	// https://bcrypt-generator.com/
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

	@Bean
	public CompromisedPasswordChecker compromisedPasswordChecker() {
		return new HaveIBeenPwnedRestApiPasswordChecker();
	}

}
