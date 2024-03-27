package ru.itis.spring_test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.spring_test.repository.UsersRepository;
import ru.itis.spring_test.security.details.UserDetailsImpl;


@Controller
public class ProfileController {
    @Autowired
    UsersRepository repository;

    @GetMapping("/profile")
    public String getProfile(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        model.addAttribute("userName", userDetails.getUsername());
        model.addAttribute("email", userDetails.getEmail());

        return "profile_page";
    }
}
