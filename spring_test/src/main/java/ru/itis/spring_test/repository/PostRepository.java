package ru.itis.spring_test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.spring_test.models.Post;
import ru.itis.spring_test.models.User;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {

    boolean existsByPostIdAndLikesContaining(Long postId, User user);
    Optional<Post> getPostByPostId(Long postId);
}
