package com.borntocode.main;

import com.borntocode.domain.Employee;

public class EvolutionOfSwitchExpression {

	// JDK 7 =Support Only Integer To The Switch Statement
	public void switchCaseExampleJava7() {
		int value = 5;
		switch (value) {
		case 1:
			System.out.println("One");
			break;
		case 5:
			System.out.println("Five");
			break;
		default:
			System.out.println("Unkonwn");
			break;
		}
	}

	// JDK 8 = Support String To The Switch Statement
	public void switchCaseStringExampleJava8() {
		String day = "Tuesday";
		switch (day) {
		case "Monday":
			System.out.println("Weekday");
			break;
		case "Tuesday":
			System.out.println("Weekday");
			break;
		case "Wednesday":
			System.out.println("Weekday");
			break;
		case "Thursday":
			System.out.println("Weekday");
			break;
		case "Friday":
			System.out.println("Weekday");
			break;
		case "Saturday":
			System.out.println("Weekend");
			break;
		case "Sunday":
			System.out.println("Weekend");
			break;

		default:
			System.out.println("Unkonwn");
			break;
		}
	}

	// JDK 8 = Support String To The Switch Statement
	enum DAYS {
		MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
	}

	public void switchEnumStringExampleJava8() {
		DAYS day = DAYS.TUESDAY;
		switch (day) {
		case MONDAY:
			System.out.println("Weekday");
			break;
		case TUESDAY:
			System.out.println("Weekday");
			break;
		case WEDNESDAY:
			System.out.println("Weekday");
			break;
		case THURSDAY:
			System.out.println("Weekday");
			break;
		case FRIDAY:
			System.out.println("Weekday");
			break;
		case SATURDAY:
			System.out.println("Weekend");
			break;
		case SUNDAY:
			System.out.println("Weekend");
			break;

		default:
			System.out.println("Unkonwn");
			break;
		}
	}

	// JDK 12 = You can return value from Switch Statement using
	// 1.break
	// 2.arrow function
	// 3.multiple values in case
//	public String switchReturnExampleJava12() {
//		String day = "Tuesday";
//		return switch (day) {
//		case "Tuesday":
//		case "Wednesday":
//		case "Thursday":
//		case "Friday":
//		case "Saturday":
//		case "Sunday":
//		case "Monday":
//			break "weekday";
//		
//		default:
//			break;
//		};
//	}

	public String switchArrowExampleJava12(String day) {
		return switch (day) {
		case "Monday" -> "Weekday";
		case "Tuesday" -> "Weekday";
		case "Wednesday" -> "Weekday";
		case "Thursday" -> "Weekday";
		case "Friday" -> "Weekday";
		case "Saturday" -> "Weekend";
		case "Sunday" -> "Weekend";
		default -> "Unknown";
		};
	}

	public String switchMultipleCaseExampleJava12(String day) {
		return switch (day) {
		case "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" -> "Weekday";
		case "Saturday", "Sunday" -> "Weekend";
		default -> "Unknown";
		};
	}

	// JDK 13 = You can return value from Switch Statement using yield
	public String switchYieldExampleJava13() {
		String day = "Tuesday";
		return switch (day) {
		case "Tuesday":
		case "Wednesday":
		case "Thursday":
		case "Friday":
		case "Monday":
			yield "weekday";
		case "Saturday":
		case "Sunday":
			yield "weekday";
		default:
			yield "unknown";
		};
	}

	// JDK 17 - Preview Feature
	// 1. Pattern Matching - you can match pattern in case level (you can pass
	// object to case)
	// 2. Null case
	// 3. Records
	public String switchPatternMatchingExampleJava17(Object object) {

		return switch (object) {
		case Integer i -> "It is an Integer";
		case String s -> "It is a String";
		case Employee e -> "It is an Employe";

		default -> "Unknown Datatype";
		};
	}

	public String switchNullCaseExampleJava17(Object object) {
		return switch (object) {
		case Integer i -> "It is an Integer";
		case String s -> "It is a String";
		case Employee e -> "Its a Employee";
		case null -> "Its null, throw the exception, your choice";
		default -> "Unknown Datatype";
		};
	}

	public static void main(String[] args) {

	}
}
