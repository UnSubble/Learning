package com.unsubble._01;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @NotNull(message = "is required!")
    @Size(min = 4, max = 16, message = "is required!")
    private String name;

    @NotNull(message = "age cannot be empty")
    @Min(value = 18, message = "age cannot be less than 18")
    @Max(value = 100, message = "age cannot be greater than 100")
    private Integer age;

    @Pattern(regexp = "[\\w_.]+@\\w+\\.\\w+", message = "invalid email address")
    private String email;
}
