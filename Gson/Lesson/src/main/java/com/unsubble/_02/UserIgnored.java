package com.unsubble._02;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class UserIgnored {
    @Expose
    private String name;
    @Expose(serialize = true, deserialize = false)
    private String email;
    @Expose(serialize = false, deserialize = true)
    private int age;
    @Expose(serialize = false, deserialize = false)
    private boolean isDeveloper;

    public UserIgnored(String name, String email, int age, boolean isDeveloper) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.isDeveloper = isDeveloper;
    }
}