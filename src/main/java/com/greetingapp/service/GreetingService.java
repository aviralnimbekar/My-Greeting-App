package com.greetingapp.service;

import com.greetingapp.Model.User;
import com.greetingapp.dto.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    public String getHelloMessage() {
        return "Hello World";
    }

    public String getCustomMessage(UserDto userDto) {
        User user = new User();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(userDto, user);
        return ("Hello " + user.getFirstName() + " " + user.getLastName());
    }
}
