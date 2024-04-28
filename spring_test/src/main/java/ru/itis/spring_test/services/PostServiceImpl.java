package ru.itis.spring_test.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.spring_test.dto.PostDto;
import ru.itis.spring_test.dto.PostForm;
import ru.itis.spring_test.models.Post;
import ru.itis.spring_test.models.User;
import ru.itis.spring_test.repository.PostRepository;
import ru.itis.spring_test.repository.UsersRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static ru.itis.spring_test.dto.PostDto.getPostsList;

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
        return getPostsList(postsOfUser);
    }

    @Override
    public List<PostDto> getPostByUsername(String username) {
        User user = usersRepository.findUserByUsername(username);
        List<Post> postsOfUser = user.getPosts();
        return getPostsList(postsOfUser);
    }

    @Override
    public PostDto addPost(Long userId, PostForm postForm) {
        User user = usersRepository.getOne(userId);

        Post newPost = Post.builder()
                .author(user)
                .text(postForm.getText())
                .img(postForm.getImg())
                .build();

        postRepository.save(newPost);
        return PostDto.from(newPost);
    }

    @Override
    public PostDto like(Long userId, Long postId) {
        User user = usersRepository.getOne(userId);
        Post post = postRepository.getOne(postId);

        boolean res = postRepository.existsByPostIdAndLikesContaining(postId, user);

        if (res) {
            post.getLikes().remove(user);
        } else {
            post.getLikes().add(user);
        }

        postRepository.save(post);
        return PostDto.from(post);
    }

    @Override
    public List<Long> userLikes(Long userId) {
        User user = usersRepository.getOne(userId);
        List<PostDto> posts = getAllPosts();
        List<Long> userLikes = new ArrayList<>();

        for (int i = 0; i < posts.size(); i++) {
            Long postId = posts.get(i).getId();
            if(postRepository.existsByPostIdAndLikesContaining(postId, user)) {
                userLikes.add(postId);
            }
        }

        return userLikes;
    }

    @Override
    public List<PostDto> getAllPosts() {
        return getPostsList(postRepository.findAll());
    }

    @Override
    public Optional<Post> getPostByPostId(Long postId) {
        return postRepository.getPostByPostId(postId);
    }

}
