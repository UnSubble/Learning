package com.unsubble._03;

import com.unsubble._01.Live;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = {"com.unsubble._01", "com.unsubble._03"})
@RestController
public class Lesson2Sec3Application {

    private Live live;

    @Autowired
    public void setLive(Live live) {
        this.live = live;
    }

    @GetMapping("/test")
    public String testAnimal() {
        return live.toString();
    }
}
