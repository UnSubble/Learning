package com.unsubble._07;

import com.unsubble._01.Live;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfigs {

    @Bean()
    public Live liveness() { // method ismi beanId'ye karşılık geliyor.
        return new Liveness("test name");
    }
}
