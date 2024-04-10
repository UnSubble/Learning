package com.unsubble._01;

public class FizzBuzz {
	
	public String stringFor(int num) {
		if (num % 3 == 0 && num % 5 == 0)
			return "FizzBuzz";
		if (num % 3 == 0)
			return "Fizz";
		if (num % 5 == 0)
			return "Buzz";
		if (num < 1 || num > 100)
			throw new IllegalArgumentException();
		return String.valueOf(num);
	}
}
