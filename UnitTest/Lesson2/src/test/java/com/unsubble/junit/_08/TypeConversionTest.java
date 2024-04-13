package com.unsubble.junit._08;

import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.JavaTimeConversionPattern;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.ValueSource;

import com.unsubble._03.Course;
import com.unsubble._03.Semester;
import com.unsubble._03.Course.CourseType;

public class TypeConversionTest {
	
	@ParameterizedTest
	@ValueSource(strings = {"MANDATORY", "ELECTIVE"})
	void testTheTest(CourseType type) {
		System.out.println(type.name());
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"101", "103"})
	void testTheTest(Course course) { // sadece string alan contructor'ı olduğu için.
									// bunun yerine public static Course createNewCourse(String name);
									// adlı bir factory metodumuz olsaydı yine typeConversion yapardı.
		System.out.println(course.getName());
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"101", "103", "105"})
	void testTheTestWithConverter(@ConvertWith(CourseConverter.class) Course course) {
		System.out.println(course.getName());
	}
	
	static class CourseConverter extends SimpleArgumentConverter {

		@Override
		protected Object convert(Object source, Class<?> targetType) throws ArgumentConversionException {
			return new Course((String) source);
		}	
	}
	
	@DisplayName("Parametrized Test")
	@ParameterizedTest(name = "{index} => Parameter: {0}")
	@ValueSource(strings = {"01.09.2018", "04.01.2019"})
	void testTheTestWithLocalDate(@JavaTimeConversionPattern("dd.MM.yyyy") LocalDate localDate) {
		System.out.println(new Semester(localDate));
	}
	
	
}
