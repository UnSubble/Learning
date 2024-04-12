package com.unsubble._08;

import static org.junit.jupiter.api.DynamicContainer.dynamicContainer;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicNode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import com.unsubble._03.Course;
import com.unsubble._03.Course.CourseType;

public class DynamicTest {
	
	@TestFactory
	Stream<DynamicNode> studentCourse() {
		return Stream.of("101","103","105").map(x -> dynamicContainer("Add course" + x + " to student", 
				Stream.of(CourseType.ELECTIVE, CourseType.MANDATORY).map(y -> dynamicTest("Add course", 
						() -> System.out.println(x + " " + y)))));
	}
}
