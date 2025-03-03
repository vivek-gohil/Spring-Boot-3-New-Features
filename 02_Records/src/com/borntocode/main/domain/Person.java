package com.borntocode.main.domain;

//Record with compact Constructor
//You can also define a compact constructor to validate or modify the data as it is being initialized.
//public record Person(String name, int age) {
//	public Person {
//		// Compact constructor, automatically generated
//		if (age < 0) {
//			throw new IllegalArgumentException("Age cannot be negative");
//		}
//	}
//}

//Step 2

//Record with Custom Methods
//You can also define custom methods within a record, just like you can with regular classes.
public record Person(String name, int age) {
	// Custom method in a record
	public String greet() {
		return "Hello, " + name + "!";
	}
}

// Step 1

//public record Person(String name, int age) {
//}

//public class Person {
//    private final String name;
//    private final int age;
//    
//    public Person(String name, int age) {
//        this.name = name;
//        this.age = age;
//    }
//    
//    public String getName() {
//        return name;
//    }
//    
//    public int getAge() {
//        return age;
//    }
//    
//    @Override
//    public String toString() {
//        return "Person[name=" + name + ", age=" + age + "]";
//    }
//    
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Person person = (Person) o;
//        return age == person.age && name.equals(person.name);
//    }
//    
//    @Override
//    public int hashCode() {
//        return Objects.hash(name, age);
//    }
//}
