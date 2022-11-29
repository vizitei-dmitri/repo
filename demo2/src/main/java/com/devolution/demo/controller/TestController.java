package com.devolution.demo.controller;

import com.devolution.demo.mapper.TestMapper;
import com.devolution.demo.request.UserRequest;
import com.devolution.demo.response.TestResponse;
import com.devolution.demo.response.UserResponse;
import com.devolution.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TestController {

    private final TestMapper mapper;

    private final UserService userService;

    public TestController(TestMapper mapper, UserService userService) {
        this.mapper = mapper;
        this.userService = userService;
    }

    @GetMapping
    public TestResponse hello() {
        return new TestResponse("Hello world!");
    }

    @PostMapping("/user")
    public UserResponse addUser(@RequestBody UserRequest userRequest) {
        return mapper.map(userService.addUser(userRequest));
    }

    @GetMapping("/user")
    public List<UserResponse> getUsers() {
        return userService.getUsers().stream().map(mapper::map).collect(Collectors.toList());
    }

    @PutMapping("/user/{id}")
    public UserResponse updateUser(@PathVariable("id") Long id, @RequestBody UserRequest userRequest) {
        return mapper.map(userService.updateUser(id, userRequest));
    }

    @GetMapping("/user/{id}")
    public UserResponse getUser(@PathVariable("id") Long id) {
        return mapper.map(userService.getUser(id));
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable("id") Long id) throws Exception {
        return userService.deleteUser(id);
    }
}
