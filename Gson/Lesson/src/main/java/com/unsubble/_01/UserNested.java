package com.unsubble._01;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserNested {
    private String name;
    private String email;
    private int age;
    private boolean isDeveloper;
    private UserAddress userAddress;
}
