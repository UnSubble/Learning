package com.unsubble._05;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import com.unsubble._03.Student;

public class TaggingTest {

	@Tag("first_test") // run configuration'dan tag'leri seçip öyle çalıştırmak lazım.
	@Test
	public void shouldCrateStudentWithIdNameSurname() {
		Student mucahit = new Student("1", "Mucahit", "kurt");

		assertEquals("Mucahit", mucahit.getName());
		assertNotEquals("Mucahitt", mucahit.getName());


		Student student = mucahit;
		assertSame(mucahit, student);
	}
	
	@Tags(value = {@Tag("second_test"), @Tag("first_test")})
	@Test
	public void test() {
		assertTrue(() -> {
			Student mehmet = new Student("2", "Mehmet", "sad");
			return mehmet.getName().endsWith("t");
		});
	}
}