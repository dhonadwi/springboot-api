package com.belajar.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/welcome")
public class WelcomeController {
  
  @GetMapping
  public String weolcome() {
    return "Welcome to Spring Boot Rest API";
  }
}
