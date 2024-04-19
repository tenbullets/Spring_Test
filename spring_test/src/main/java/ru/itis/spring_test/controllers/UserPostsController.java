package ru.itis.spring_test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.spring_test.dto.PostDto;
import ru.itis.spring_test.models.Post;
import ru.itis.spring_test.repository.UsersRepository;
import ru.itis.spring_test.security.details.UserDetailsImpl;
import ru.itis.spring_test.services.PostService;
import ru.itis.spring_test.services.PostServiceImpl;

import java.util.List;

@Controller
public class UserPostsController {

    @Autowired
    UsersRepository repository;

    @Autowired
    private PostServiceImpl postService;

    @GetMapping("/theWall")
    public String getProfile(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        List<PostDto> posts = postService.getPostByUsername(userDetails.getUsername());
        model.addAttribute("posts", posts);

        return "theWall";
    }

}
