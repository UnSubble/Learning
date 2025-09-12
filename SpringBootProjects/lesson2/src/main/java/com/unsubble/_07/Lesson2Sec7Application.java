package com.unsubble._07;

import com.unsubble._01.Live;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = {"com.unsubble._01", "com.unsubble._07"})
@RestController
public class Lesson2Sec7Application {

    private Live live;

    @Autowired
    public void setLive(@Qualifier("liveness") Live live) {
        this.live = live;
    }

    @GetMapping("/test")
    public String testBacteria() {
        return live.toString();
    }
}
