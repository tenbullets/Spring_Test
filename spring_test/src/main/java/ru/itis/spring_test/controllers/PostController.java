package ru.itis.spring_test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.spring_test.dto.PostDto;
import ru.itis.spring_test.dto.PostForm;
import ru.itis.spring_test.models.User;
import ru.itis.spring_test.security.details.UserDetailsImpl;
import ru.itis.spring_test.services.PostService;
import ru.itis.spring_test.services.UsersService;

import java.util.List;
import java.util.Objects;
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

        postService.addPost(user.get().getId(), form);
        return "redirect:/profile";
    }

    @GetMapping("/feed")
    public String getFeedPage(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        Optional<User> user = usersService.getUserByEmail(userDetails.getEmail());

        List<Long> likes = postService.userLikes(user.get().getId());
        List<PostDto> postsList = postService.getAllPosts();

        if(likes.isEmpty() || postsList.isEmpty()) {
            for (int i = 0; i < postsList.size(); i++) {
                PostDto post = postsList.get(i);
                post.setUserLike("like");
            }
        } else {
            for (int i = 0; i < postsList.size(); i++) {
                PostDto post = postsList.get(i);
                for (int j = 0; j < likes.size(); j++) {
                    if(Objects.equals(post.getId(), likes.get(j))) {
                        post.setUserLike("like pressed");
                        break;
                    } else {
                        post.setUserLike("like");
                    }
                }
            }
        }

        model.addAttribute("postsList", postsList);
        return "feed_page";
    }
}