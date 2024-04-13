package com.unsubble.junit._07;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.unsubble._03.Student;

@TestInstance(Lifecycle.PER_CLASS)
public class RepeatedTests {
	
	private Student student;
	
	@BeforeAll
	void setUp() {
		student = new Student("1", "Ahmet", "Can");
	}

	@DisplayName("Repeated test 5 times")
	@RepeatedTest(value = 5, name = RepeatedTest.DISPLAY_NAME_PLACEHOLDER + " => " + 
			RepeatedTest.CURRENT_REPETITION_PLACEHOLDER + " times")
	void testName(RepetitionInfo repetitionInfo) throws Exception {
		System.out.println(repetitionInfo.getCurrentRepetition());
		assertEquals("Ahmet", student.getName());
	}
}
