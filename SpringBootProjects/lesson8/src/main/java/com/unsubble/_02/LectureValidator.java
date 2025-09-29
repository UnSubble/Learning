package com.unsubble._02;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class LectureValidator implements ConstraintValidator<Lecture, String> {

    private String lecturePrefix;

    @Override
    public void initialize(Lecture constraintAnnotation) {
        lecturePrefix = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return !(value == null || !value.startsWith(lecturePrefix));
    }
}
