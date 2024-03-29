package ru.itis.spring_test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.spring_test.dto.PostAjaxDto;
import ru.itis.spring_test.dto.PostDto;
import ru.itis.spring_test.dto.PostForm;
import ru.itis.spring_test.models.User;
import ru.itis.spring_test.security.details.UserDetailsImpl;
import ru.itis.spring_test.services.PostService;
import ru.itis.spring_test.services.PostServiceImpl;
import ru.itis.spring_test.services.UsersService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class SavePostViaAjaxController {
    @Autowired
    PostService postService;

    @Autowired
    PostServiceImpl postServiceImpl;

    @Autowired
    UsersService usersService;

    @PostMapping("/savePost")
    public ResponseEntity<List<PostDto>> getSearchResultViaAjax(@Valid @RequestBody PostAjaxDto post, Errors errors, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        Optional<User> user = usersService.getUserByEmail(userDetails.getEmail());
        PostForm postForm = new PostForm();
        postForm.setText(post.getText());

        postService.addPost(user.get().getId(), postForm);
        List<PostDto> newPostsList = postService.getPostByUsername(userDetails.getUsername());

        return ResponseEntity.ok(newPostsList);
    }
}
