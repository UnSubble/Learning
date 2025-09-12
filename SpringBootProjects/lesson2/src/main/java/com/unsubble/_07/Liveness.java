package com.unsubble._07;

import com.unsubble._01.Live;

public class Liveness implements Live {
    private String name;

    public Liveness(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Liveness{" +
                "name='" + name + '\'' +
                '}';
    }
}
