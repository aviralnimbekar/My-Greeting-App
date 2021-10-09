package com.greetingapp.controller;

import com.greetingapp.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greet")
public class GreetingAppController {

    @Autowired
    private GreetingService greetingService;

    @GetMapping({"", "/", "/hello"})
    public String getWelcomeMessage() {
        return greetingService.getHelloMessage();
    }
}
