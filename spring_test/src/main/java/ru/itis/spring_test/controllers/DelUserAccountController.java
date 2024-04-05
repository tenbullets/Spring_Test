package ru.itis.spring_test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.spring_test.services.UsersService;

@Controller
public class DelUserAccountController {
    @Autowired
    UsersService service;

    @PostMapping("/delUserAccount")
    public String delUserAccount(@AuthenticationPrincipal UserDetails userDetails) {
        service.ban(service.getUserByUsername(userDetails.getUsername()));

        return "/welcome_page";
    }
}
