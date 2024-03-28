package ru.itis.spring_test.services;

import org.springframework.stereotype.Repository;
import ru.itis.spring_test.dto.PostDto;
import ru.itis.spring_test.dto.PostForm;

import java.util.List;


public interface PostService {

    List<PostDto> getPostByUser(Long userId);

    PostDto addPost(Long userId, PostForm postForm);

    PostDto like(Long userId, Long postId);

    List<PostDto> getAllPosts();

}
