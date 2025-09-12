package com.unsubble._05;

import com.unsubble._01.Live;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Mushroom implements Live {
    @Value("test name")
    private String name;

    @Override
    public String toString() {
        return "Mushroom{" +
                "name='" + name + '\'' +
                '}';
    }
}
