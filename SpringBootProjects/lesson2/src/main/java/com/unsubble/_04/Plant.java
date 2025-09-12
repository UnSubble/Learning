package com.unsubble._04;

import com.unsubble._01.Live;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy // obje, ihtiyaç duyulmadığı sürece üretilmez.
public class Plant implements Live {
    @Value("test name")
    private String name;

    public Plant() {
        System.out.println("Plant was created when the app needed it!");
    }

    @Override
    public String toString() {
        return "Plant{" +
                "name='" + name + '\'' +
                '}';
    }
}
