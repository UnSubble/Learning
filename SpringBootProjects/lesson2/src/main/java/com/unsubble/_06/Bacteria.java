package com.unsubble._06;

import com.unsubble._01.Live;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Bacteria implements Live {
    @Value("test name")
    private String name;

    @PostConstruct
    public void doStuff() {
        System.out.println("after was created...");
    }

    @PreDestroy
    public void doStuffAgain() {
        System.out.println("before being destroyed...");
    }

    @Override
    public String toString() {
        return "Bacteria{" +
                "name='" + name + '\'' +
                '}';
    }
}
