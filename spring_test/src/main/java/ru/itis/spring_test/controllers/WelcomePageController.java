package ru.itis.spring_test.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomePageController {
    @GetMapping("/welcome")
    public String getWelcomePage() { return "welcome_page"; }
}
