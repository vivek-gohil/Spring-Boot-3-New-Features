package com.borntocode.main;

import com.borntocode.main.domain.Person;

public class PersonRecordMainV2 {
	public static void main(String[] args) {
		Person person = new Person("Alice", 30);
		System.out.println(person.greet()); // Hello, Alice!
	}
}
