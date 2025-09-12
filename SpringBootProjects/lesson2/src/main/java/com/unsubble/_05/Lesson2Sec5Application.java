package com.unsubble._05;

import com.unsubble._01.Live;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = {"com.unsubble._01", "com.unsubble._05"})
@RestController
public class Lesson2Sec5Application {

    private Live mlive;
    private Live mlive2;
    private Live plive;
    private Live plive2;

    @Autowired
    public Lesson2Sec5Application(@Qualifier("mushroom") Live mlive,
                                  @Qualifier("mushroom")Live mlive2,
                                  @Qualifier("person") Live plive,
                                  @Qualifier("person") Live plive2) {
        this.mlive = mlive;
        this.mlive2 = mlive2;
        this.plive = plive;
        this.plive2 = plive2;
    }

    @GetMapping("/test")
    public String testEquals() {
        return String.format("mushrooms: %s, persons: %s",mlive == mlive2, plive == plive2);
    }
}
