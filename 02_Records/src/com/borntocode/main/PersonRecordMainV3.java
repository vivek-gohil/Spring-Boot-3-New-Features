package com.borntocode.main;

import com.borntocode.main.domain.Person;

public class PersonRecordMainV3 {
	public static void main(String[] args) {
		Object obj = new Person("Alice", 30);

		String result = switch (obj) {
		case Person(String name, int age) -> "Person: " + name + ", Age: " + age;
		default -> "Unknown type";
		};

		System.out.println(result); // Person: Alice, Age: 30
	}
}
