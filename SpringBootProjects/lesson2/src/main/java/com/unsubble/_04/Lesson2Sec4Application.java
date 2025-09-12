package com.unsubble._04;

import com.unsubble._01.Live;
import com.unsubble.app.Lesson2Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = {"com.unsubble._01", "com.unsubble._04"})
@RestController
public class Lesson2Sec4Application {

    private Live live;

    @Autowired
    public Lesson2Sec4Application(@Qualifier("plant") Live live) {
        System.out.println(getClass().getSimpleName() + " was created when the app needed it!");
        this.live = live;
    }

    @GetMapping("/test")
    public String testLazy() {
        return live.toString();
    }
}
