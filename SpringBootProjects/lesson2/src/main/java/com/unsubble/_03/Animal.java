package com.unsubble._03;

import com.unsubble._01.Live;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary // -> qualifier belirtilmemişse birincilik buna tanınır.
// ama qualifier daha yüksek önceliğe sahiptir.
public class Animal implements Live {
    @Value("test name")
    private String name;

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                '}';
    }
}
