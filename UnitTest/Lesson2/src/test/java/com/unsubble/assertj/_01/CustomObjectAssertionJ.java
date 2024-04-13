package com.unsubble.assertj._01;

import com.unsubble._03.Department;
import com.unsubble._03.Student;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CustomObjectAssertionJ {

    @SuppressWarnings("deprecation")
    @Test
    void createStudent() {
        Student ahmet = new Student("1", "ahmet", "asd");
        Student mucahit = new Student("2", "mucahit", "asd");

        ahmet.setDepartment(new Department());

        assertThat(ahmet).as("Check student ahmet info")
                .isNotNull().hasSameClassAs(mucahit).isExactlyInstanceOf(Student.class)
                .isNotEqualTo(mucahit).isEqualToComparingOnlyGivenFields(mucahit, "surname")
                .hasFieldOrProperty("name").hasNoNullFieldsOrProperties();
    }

    @Test
    void createStudent2() {
        Student ahmet = new Student("1", "ahmet", "asd");

        CustomAssertion.assertThat(ahmet).hasName("ahmet");
    }

}
