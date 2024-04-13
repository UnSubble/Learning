package com.unsubble.assertj._01;

import com.unsubble._03.Student;
import org.assertj.core.api.AbstractAssert;

import java.util.Objects;

public class CustomAssertion extends AbstractAssert<CustomAssertion, Student> {

    protected CustomAssertion(Student student) {
        super(student, CustomAssertion.class);
    }

    public static CustomAssertion assertThat(Student actual) {
        return new CustomAssertion(actual);
    }

    public CustomAssertion hasName(String name) {
        isNotNull();
        if (!Objects.equals(name, actual.getName()))
            failWithMessage("Given name and actual name are not same!");
        return this;
    }
}
