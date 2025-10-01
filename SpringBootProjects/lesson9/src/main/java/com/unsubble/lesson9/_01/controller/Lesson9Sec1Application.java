package com.unsubble.lesson9._01.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication(scanBasePackages = "com.unsubble.lesson9")
@Controller
public class Lesson9Sec1Application {

    @GetMapping("/")
    public String getHome() {
        return "home";
    }

    @GetMapping("myLoginPage")
    public String getMyLoginPage() {
        return "simpleLogin";
    }
}
