package ru.itis.spring_test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.spring_test.models.User;

public interface UsersRepository extends JpaRepository<User, Long> {}
