package ru.itis.spring_test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.spring_test.models.Banned;
import ru.itis.spring_test.models.Post;
import ru.itis.spring_test.models.User;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    User findUserByUsername(String username);
    Optional<User> findUserById(Long id);

}
