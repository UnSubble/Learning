package com.unsubble._02;

import com.unsubble._01.Live;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = {"com.unsubble._01"})
@RestController
public class Lesson2Sec2Application {
    private Live live;

    @Autowired
    public void setLive(@Qualifier("person") Live live) {
        // qualifier'lar candidate'lerden seçilir. (Person class'ı default "person" id'sine sahip)
        this.live = live;
    }

    @GetMapping("/test")
    public String testLive() {
        return live.toString();
    }
}
