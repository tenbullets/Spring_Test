package ru.itis.spring_test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.spring_test.models.Role;
import ru.itis.spring_test.models.User;
import ru.itis.spring_test.repository.UsersRepository;
import ru.itis.spring_test.security.details.UserDetailsImpl;


@Controller
public class ProfileController {
    @Autowired
    UsersRepository repository;

    @GetMapping("/profile")
    public String getProfile(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        User user = repository.findUserByUsername(userDetails.getUsername());

        model.addAttribute("userName", userDetails.getUsername());
        model.addAttribute("email", userDetails.getEmail());

        if(user.getRole().equals(Role.USER)) {
            return "profile_page";
        } else {
            return "admin_page";
        }
    }
}
