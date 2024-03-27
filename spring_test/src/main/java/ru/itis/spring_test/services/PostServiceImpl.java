package ru.itis.spring_test.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import ru.itis.spring_test.dto.PostDto;
import ru.itis.spring_test.dto.PostForm;
import ru.itis.spring_test.models.Post;
import ru.itis.spring_test.models.User;
import ru.itis.spring_test.repository.PostRepository;
import ru.itis.spring_test.repository.UsersRepository;

import java.util.List;

@Component
public class PostServiceImpl implements PostService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PostRepository postRepository;


    @Override
    public List<PostDto> getPostByUser(Long userId) {
        User user = usersRepository.getOne(userId);
        List<Post> postsOfUser = user.getPosts();
        return PostDto.getPostsList(postsOfUser);
    }

    @Override
    public PostDto addPost(Long userId, PostForm postForm) {
        User user = usersRepository.getOne(userId);

        Post newPost = Post.builder()
                .author(user)
                .text(postForm.getText())
                .build();

        postRepository.save(newPost);
        return PostDto.from(newPost);
    }

    @Override
    public PostDto like(Long userId, Long postId) {
        User user = usersRepository.getOne(userId);
        Post post = postRepository.getOne(postId);
        if (postRepository.existsByPostIdAndLikesContaining(postId, user)) {
            post.getLikes().remove(user);
        } else {
            post.getLikes().add(user);
        }
        postRepository.save(post);
        return PostDto.from(post);
    }
}