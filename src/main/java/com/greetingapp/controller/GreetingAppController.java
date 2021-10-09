package com.greetingapp.controller;

import com.greetingapp.Model.User;
import com.greetingapp.dto.UserDto;
import com.greetingapp.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/greet")
public class GreetingAppController {

    @Autowired
    private GreetingService greetingService;

    @GetMapping({"", "/", "/hello"})
    public String getWelcomeMessage() {
        return greetingService.getHelloMessage();
    }

    @GetMapping("/customMessage")
    public String getCustomMessage(@RequestBody UserDto userDto) {
        return greetingService.getCustomMessage(userDto);
    }

    @GetMapping("/find_greeting")
    public User findGreetById(@RequestParam int id) {
        return greetingService.getGreetById(id);
    }

    @GetMapping("/get_all_greetings")
    public List<User> findAllGreeting() {
        return greetingService.getAllGreet();
    }

    @DeleteMapping("/delete_greet")
    public String deleteGreet(@RequestParam int id) {
        return greetingService.deleteGreet(id);
    }
}
