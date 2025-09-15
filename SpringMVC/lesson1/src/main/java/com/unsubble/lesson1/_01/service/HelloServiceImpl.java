package com.unsubble.lesson1._01.service;

import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String createMessage() {
        return "message crated!";
    }
}
