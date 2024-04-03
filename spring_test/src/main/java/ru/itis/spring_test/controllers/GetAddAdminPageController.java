package ru.itis.spring_test.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.spring_test.services.UsersService;

@Controller
public class GetAddAdminPageController {
    @Autowired
    UsersService usersService;

    @GetMapping("/addAdmin")
    public String GetAddAdminPage(Model model) {
        model.addAttribute("usersList", usersService.getAllUsers());
        return "add_admin_page";
    }

}
