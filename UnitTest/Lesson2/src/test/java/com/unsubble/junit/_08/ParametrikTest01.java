package com.unsubble.junit._08;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.EnumSource.Mode;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.unsubble._03.Course.CourseType;
import com.unsubble._03.Student;

public class ParametrikTest01 {
	private Student student;
	
	@TestInstance(Lifecycle.PER_CLASS)
	@Nested
	class ValueSourceDemo {
		
		@BeforeAll
		void setUp() {
			student = new Student("1", "Ahmet", "Yilmaz");
		}
		
		@ParameterizedTest
		@ValueSource(strings = {"101", "103", "105"} )
		void testTest(String str) {
			System.out.println(str);
		}
	}
	
	@TestInstance(Lifecycle.PER_CLASS)
	@Nested
	class EnumSourceDemo {
		
		@BeforeAll
		void setUp() {
			student = new Student("1", "Ahmet", "Yilmaz");
		}
		
		@ParameterizedTest
		@EnumSource(value = CourseType.class)
		void testTest(CourseType type) {
			System.out.println(type.name());
		}
		
		@ParameterizedTest
		@EnumSource(value = CourseType.class, names = "MANDATORY")
		void includeEnumValuesTest(CourseType type) {
			System.out.println(type.name());
		}
		
		@ParameterizedTest
		@EnumSource(value = CourseType.class, mode = Mode.EXCLUDE, names = "MANDATORY")
		void excludeEnumValuesTest(CourseType type) {
			System.out.println(type.name());
		}
	}
	
	@TestInstance(Lifecycle.PER_CLASS)
	@Nested
	class MethodSourceDemo {
		
		@BeforeAll
		void setUp() {
			student = new Student("1", "Ahmet", "Yilmaz");
		}
		
		@ParameterizedTest
		@MethodSource("addCourseToStudent") // eğer name belirtmeseydik testTest isimli overloaded metot 
											// arayacaktı.
		void testTest(String str) {
			System.out.println(str);
		}
		
		Stream<String> addCourseToStudent() {
			return Stream.of("101", "103", "105");
		}
		
		@ParameterizedTest
		@MethodSource({"addCourseToStudent2"})
		void testTest2(String str, CourseType type) {
			System.out.println(str + " " + type.name());
		}
		
		Stream<Arguments> addCourseToStudent2() {
			return Stream.of(Arguments.of("101", CourseType.MANDATORY),
					Arguments.of("103", CourseType.ELECTIVE));
					
		}
	}

	@TestInstance(Lifecycle.PER_CLASS)
	@Nested
	class CsvSourceDemo {
		
		@ParameterizedTest
		@CsvSource({"101,MANDATORY","103,ELECTIVE","105,MANDATORY"})
		void testTest2(String str, CourseType type) {
			System.out.println(str + " " + type.name());
		}
	}

	@TestInstance(Lifecycle.PER_CLASS)
	@Nested
	class CsvFileSourceDemo {
		
		@ParameterizedTest
		@CsvFileSource(resources = "/test.csv", numLinesToSkip = 1)
		void testTest2(String str, CourseType type) {
			System.out.println(str + " " + type.name());
		}
	}

	@TestInstance(Lifecycle.PER_CLASS)
	@Nested
	class ArgumentSourceDemo {
		
		@BeforeAll
		void setUp() {
			student = new Student("1", "Ahmet", "Yilmaz");
		}
		
		@ParameterizedTest
		@ArgumentsSource(ArgumentSourceProvider.class)
		void testTest(String str) {
			System.out.println(str);
		}
	}
	
	static class ArgumentSourceProvider implements ArgumentsProvider {

		@Override
		public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
			return Stream.of(Arguments.of("101"), Arguments.of("102"), Arguments.of("103"));
		}
		
	}
}
