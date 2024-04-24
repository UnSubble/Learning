package com.unsubble.assertj._01;

import com.unsubble._03.Student;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

public class CollectionAssertJ {

    @Test
    void addStudent() {
        final Student ahmet = new Student("1", "Ahmet", "asd");
        final Student mucahit = new Student("2", "Mucahit", "kurt");
        final Student mehmet = new Student("3", "Mehmet", "sadf");

        List<Student> students = List.of(ahmet, mucahit, mehmet);

        assertThat(students).as("Student's list").isNotNull().isNotEmpty()
                .hasSize(3).contains(ahmet, mehmet)
                .containsOnly(ahmet, mehmet, mucahit) // sıra önemli değil
                .containsExactly(ahmet, mucahit, mehmet) // sıra önemli
                ;

        assertThat(students).filteredOn(x -> x.getName().startsWith("M")).hasSize(2);
    }
}
