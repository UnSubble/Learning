package com.unsubble._02;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private String name;

    @NotNull
    @Lecture(value = "LU", message = "the lecture must starts with LU")
    private String lecture;
}
