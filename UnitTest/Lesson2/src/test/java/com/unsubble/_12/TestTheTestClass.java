package com.unsubble._12;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.extension.ExtendWith;

import com.unsubble._03.Student;

@ExtendWith(ParameterResolverExtensionImpl.class)
public class TestTheTestClass {
	
	final Student ahmet;
	
	public TestTheTestClass(Student ahmet) {
		this.ahmet = ahmet;
	}

	@TestFactory
	public Stream<DynamicTest> test() {
		return Stream.of(dynamicTest("Test 1", () -> {
			assertEquals("Ahmet", ahmet.getName());
		}));
	}

}
