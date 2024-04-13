package com.unsubble.assertj._01;

import com.unsubble._03.Student;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class StringAssertJ {
    @Test
    void createStudent() {
        final Student student = new Student("1", "Mucahit", "Kurt");
        assertThat(student.getName()).as("Student's name % s", student.getName())
                .doesNotContainOnlyWhitespaces().isNotNull().isNotEmpty()
                .isNotBlank().isEqualTo("Mucahit").isEqualToIgnoringCase("mucahit")
                .isIn("Mucahit", "Kurt", "Ali").matches("^M\\w{5}t$");
    }
}
