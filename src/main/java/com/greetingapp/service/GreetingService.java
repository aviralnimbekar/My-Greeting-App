package com.greetingapp.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    public String getHelloMessage() {
        return "Hello World";
    }
}