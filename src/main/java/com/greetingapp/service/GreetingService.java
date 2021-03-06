package com.greetingapp.service;

import com.greetingapp.Model.User;
import com.greetingapp.dto.UserDto;
import com.greetingapp.repository.GreetingRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GreetingService {

    @Autowired
    private GreetingRepository greetingRepository;

    public String getHelloMessage() {
        return "Hello World";
    }

    public String getCustomMessage(UserDto userDto) {
        User user = new User();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(userDto, user);
        greetingRepository.save(user);
        return ("Hello " + user.getFirstName() + " " + user.getLastName());
    }

    public User getGreetById(int id) {
        Optional<User> greetById = greetingRepository.findById(id);
        return greetById.orElse(null);
    }

    public List<User> getAllGreet() {
        return greetingRepository.findAll();
    }

    public String deleteGreet(int id) {
        Optional<User> optionalUser = greetingRepository.findById(id);
        if (optionalUser.isPresent()) {
            greetingRepository.delete(optionalUser.get());
            return "Record deleted successfully";
        }
        return "Record not available";
    }
}
