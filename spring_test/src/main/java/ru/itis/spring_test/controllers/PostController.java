package ru.itis.spring_test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.spring_test.dto.PostForm;
import ru.itis.spring_test.models.User;
import ru.itis.spring_test.security.details.UserDetailsImpl;
import ru.itis.spring_test.services.PostService;
import ru.itis.spring_test.services.UsersService;

import java.util.Optional;

@Controller
public class PostController {

    @Autowired()
    private PostService postService;

    @Autowired()
    private UsersService usersService;

    @GetMapping("/addPost")
    public String getSignUpPage() {
        return "add_post";
    }

    @PostMapping("/addPost")
    public String addPost(@AuthenticationPrincipal UserDetailsImpl userDetails, PostForm form) {
        Optional<User> user = usersService.getUserByEmail(userDetails.getEmail());

//        System.out.println("user id = " + user.get().getId() + ", text:" + form.getText());
        postService.addPost(user.get().getId(), form);

        return "redirect:/signUp";
    }
}
