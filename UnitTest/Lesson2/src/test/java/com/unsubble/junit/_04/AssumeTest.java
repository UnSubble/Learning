package com.unsubble.junit._04;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import org.junit.jupiter.api.Test;

import com.unsubble._03.Student;

public class AssumeTest {

	@Test
	public void testTheTest() {
		assumeTrue(System.getProperty("ENV") != null, "Aborting Test: System property env doesn't exist!");
		assumeTrue(System.getProperty("ENV").equals("dev")); // false verirse skip'lenir. Yani test
															// fail olmaz ve sonlanır.
		assertFalse(true, () -> {
			System.out.println("s");
			return "s";
		});
	}

	@Test
	public void testTheTest2() {
		assumingThat(System.getProperty("ENV") != null, () -> System.out.println("calistim")); // burada ise
																	// test sonlanmaz ve alttakinden devam eder.
																	// (assumingThat olduğu için)
		final Student student = new Student("1", "Ahmet", "Can");
		assertAll("Student Information",
				() -> assertEquals("Ahmet", student.getName()),
				() -> assertEquals("Can", student.getSurname()));
	}
}
