package com.example.coding_challenge.controller;

import com.example.coding_challenge.dto.UserDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    List<UserDto> userDtos = new ArrayList<>();

    @GetMapping("/users")
    public List<UserDto> getUsers() {
        return userDtos;
    }

    @GetMapping("/users/by-id/{id}")
    public UserDto getById(@PathVariable int id) {
        for (UserDto user : userDtos) {
            if (user.getId() == id) {
                return user;
            }
        }
        return new UserDto();
    }


    @GetMapping("/users/by-name/{name}")
    public UserDto getByName(@PathVariable String name) {
        for (UserDto user : userDtos) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return new UserDto();
    }

    @PostMapping("/users")
    public void addUser(@RequestBody UserDto userDto) {
        userDtos.add(userDto);
    }
}
