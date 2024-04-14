package ru.itis.spring_test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.spring_test.dto.ConfirmForm;
import ru.itis.spring_test.models.User;
import ru.itis.spring_test.services.UsersService;

import java.util.Optional;

@Controller
public class ConfirmController {

    @Autowired
    UsersService usersService;

    @PostMapping("/confirm")
    public String confirmAccount(ConfirmForm confirmForm) {
        String key = confirmForm.getKey();
        String username = confirmForm.getUsername();

        Optional<User> u = usersService.getUserByUsername(username);
        if(key.equals(u.get().getKey())) {
            usersService.confirmUser(u);
            return "redirect:/signIn";
        } else {
            return "redirect:/welcome";
        }

    }
}
