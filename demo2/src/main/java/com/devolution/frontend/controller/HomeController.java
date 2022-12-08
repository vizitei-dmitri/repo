package com.devolution.frontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
    @GetMapping
    public String hello() {
        return "Hello world!";
    }
}
