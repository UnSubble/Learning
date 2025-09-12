package com.unsubble._06;

import com.unsubble._01.Live;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = {"com.unsubble._01", "com.unsubble._06"})
@RestController
public class Lesson2Sec6Application {

    private Live live;

    @Autowired
    public void setLive(@Qualifier("bacteria") Live live) {
        this.live = live;
    }

    @GetMapping("/test")
    public String testBacteria() {
        return live.toString();
    }
}
