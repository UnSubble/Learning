package com.unsubble._01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class FizzBuzzTest {
	
	private FizzBuzz fizzBuzz;
	
	@BeforeEach // her birinden önce çalıştırır. // bunun tam tersi olan @AfterEach de var
				// veya her şeyden önce çalıştırmak istiyorsak @BeforeAll var. (class'tan da önce çalışır.)
				// Bunun da tam tersi olan @AfterAll var. (bu all annotationları static olmalıdır)
	public void setUp() {
		fizzBuzz = new FizzBuzz();
	}

	@Test
	public void returnFizzWhenTheNumberIsDividedByThree() {
		assertEquals("Fizz", fizzBuzz.stringFor(3));
	}
	
	@Test
	public void returnBuzzWhenTheNumberIsDividedByFive() {
		assertEquals("Buzz", fizzBuzz.stringFor(5));
	}
	
	@Test
	public void returnFizzBuzzWhenThenNumberIsDividedBothOfThreeAndFive() {
		assertEquals("FizzBuzz", fizzBuzz.stringFor(15));
	}
	
	@Test
	public void throwAnExceptionWhenTheNumberIsOutOfRange() {
		assertThrows(IllegalArgumentException.class, () -> fizzBuzz.stringFor(101));
	}
	
	@Test
	public void returnTheNumberItselfWhenTheNumberIsNotDividedAnyOfThreeOrFive() {
		assertEquals("4", fizzBuzz.stringFor(4));
	}
	
	@Disabled("This test method is disabled for now") // ignore gibi çalışır.
	@Test
	public void disabled() {
		System.out.println("Hello");
	}
}
