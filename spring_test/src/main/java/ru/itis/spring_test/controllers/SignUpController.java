package ru.itis.spring_test.controllers;

import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.spring_test.dto.UserForm;
import ru.itis.spring_test.services.SignUpService;

@Controller
public class SignUpController {

    @Autowired
    private SignUpService signUpService;

    @GetMapping("/signUp")
    public String getSignUpPage() {
        return "sign_up_page";
    }

    @PostMapping("/signUp")
    public String signUp(UserForm form, Model model) {
        if(form.getPassword().equals(form.getPasswordCheck())) {
            signUpService.addUser(form);
            model.addAttribute("username", form.getUsername());
            return "activation_page";
        }
        return "redirect:/signUp";
    }
}
