package com.unsubble.lesson7._01.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    String id;
    String name;
    String country;
}
