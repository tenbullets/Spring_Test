package ru.itis.spring_test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.spring_test.dto.PostPin;
import ru.itis.spring_test.models.User;
import ru.itis.spring_test.security.details.UserDetailsImpl;
import ru.itis.spring_test.services.PostService;
import ru.itis.spring_test.services.UsersService;
import ru.itis.spring_test.services.UsersServiceImpl;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class LikesController {

    @Autowired
    PostService postService;

    @Autowired
    UsersService usersService;

    @PostMapping("/sendLike")
    public Integer getLikesViaAjax(@Valid @RequestBody PostPin post, Errors errors, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        Optional<User> u = usersService.getUserByEmail(userDetails.getEmail());

//        postService.like(u.get().getId(), Long.valueOf(post.getPostId()));

        System.out.println("POST ID = " + post.getPostId() + ", USER ID = " + u.get().getId());

        return post.getPostId();
    }
}
