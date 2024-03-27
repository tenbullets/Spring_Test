package ru.itis.spring_test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.spring_test.models.Post;
import ru.itis.spring_test.models.User;

public interface PostRepository extends JpaRepository<Post, Long> {
    boolean existsByPostIdAndLikesContaining(Long postId, User user);
}
