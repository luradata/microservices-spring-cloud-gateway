package com.luradata.book_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class SampleController {

    @GetMapping
    public String hello() {
        return "Hello from Book Service";
    }
}
