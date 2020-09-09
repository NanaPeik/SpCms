package com.example.banner.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
@RestController
public class Home {
    @GetMapping
    public String Home(){
        return "Appllication is working!!! "+new Date();
    }
}
