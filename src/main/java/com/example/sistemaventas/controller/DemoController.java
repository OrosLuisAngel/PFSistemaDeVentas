package com.example.sistemaventas.controller;


import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class DemoController {

    @PostMapping("demo")
    public String demo() {
        
        return "Demo endpoint";
    }
    
}
