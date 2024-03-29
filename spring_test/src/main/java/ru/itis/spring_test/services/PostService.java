package ru.itis.spring_test.services;

import ru.itis.spring_test.dto.PostDto;
import ru.itis.spring_test.dto.PostForm;
import ru.itis.spring_test.models.Post;
import ru.itis.spring_test.models.User;

import java.util.List;
import java.util.Optional;


public interface PostService {

    List<PostDto> getPostByUser(Long userId);

    PostDto addPost(Long userId, PostForm postForm);

    PostDto like(Long userId, Long postId);

    List<PostDto> getAllPosts();

    Optional<Post> getPostByPostId(Long postId);

    List<PostDto> getPostByUsername(String username);

}
