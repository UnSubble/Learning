package com.unsubble._01;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class UserSimple {
    private String name;
    private String email;
    private int age;
    private boolean isDeveloper;

    public UserSimple(String name, String email, int age, boolean isDeveloper) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.isDeveloper = isDeveloper;
    }
}
