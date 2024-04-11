package com.unsubble._08;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.unsubble._03.Course.CourseType;

public class TypeConversionTest {
	
	@ParameterizedTest
	@ValueSource(strings = {"MANDATORY", "ELECTIVE"})
	void testTheTest(CourseType type) {
		System.out.println(type.name());
	}
	
	 
}
