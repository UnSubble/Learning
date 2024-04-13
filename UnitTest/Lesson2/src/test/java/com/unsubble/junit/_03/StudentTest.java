package com.unsubble.junit._03;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import com.unsubble._03.Student;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class StudentTest {

	@Test
	public void shouldCrateStudentWithIdNameSurname() {
		Student mucahit = new Student("1", "Mucahit", "kurt");
		
		assertEquals("Mucahit", mucahit.getName());
		assertNotEquals("Mucahitt", mucahit.getName());
		
		assertTrue(() -> {
			Student mehmet = new Student("2", "Mehmet", "sad");
			return mehmet.getName().endsWith("t");
		});
		
		Student student = mucahit;
		assertSame(mucahit, student);
	}
	
	@Test
	@Disabled
	public void testTimeout() {
		assertTimeout(Duration.ofMillis(1), () -> { // kodun bitmesini bekler ve arada geçen süreyi söyler
			Thread.sleep(2);
		});
		
		assertTimeoutPreemptively(Duration.ofMillis(1), () -> { // kodun bitmesini beklemez
			Thread.sleep(2);
		});
	}
}
