package com.unsubble._07;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;

import com.unsubble._03.Student;

@DisplayName("Dependency")
public class DependencyInjection {
	
	private Student student;
	
	public DependencyInjection(TestInfo testInfo) {
		System.out.println(testInfo.getDisplayName());
	}
	
	@BeforeEach
	void setStudent(TestInfo testInfo) {
		if (testInfo.getTags().contains("Ahmet"))
			student = new Student("1", "Ahmet", "Can");
		else
			student = new Student("1", "Mehmet", "Can");
	}

	@Test
	@DisplayName("Ahmet")
	@Tag("Ahmet")
	void testTest(TestReporter testReporter) throws Exception {
		testReporter.publishEntry("startTime", LocalTime.now().toString());
		assertEquals("Ahmet", student.getName());
		testReporter.publishEntry("endTime", LocalTime.now().toString());
	}
	
	@Test
	@DisplayName("Mehmet")
	@Tag("Mehmet")
	void testTheTest(TestInfo testInfo) throws Exception {
		System.out.println(testInfo.getTags());
		assertEquals("Mehmet", student.getName());
	}
}
