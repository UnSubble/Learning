package com.unsubble.junit._09;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

public class ExtensionModelTest2 {
	
	@RegisterExtension
	static TestLoggerExtension testLoggerExtension = new TestLoggerExtension();

	@Nested
	@DisplayName("Test 1")
	public class Test_1 {
		@Test
		public void test() {
			assertTrue(true);
		}
	}
	
	@Nested
	@DisplayName("Test 2")
	public class Test_2 {
		@Test
		public void test() {
			assertTrue(true);
		}
	}
}
