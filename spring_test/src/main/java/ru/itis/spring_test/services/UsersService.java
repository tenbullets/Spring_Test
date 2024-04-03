package ru.itis.spring_test.services;

import ru.itis.spring_test.dto.UserDto;
import ru.itis.spring_test.models.User;

import java.util.List;
import java.util.Optional;

public interface UsersService {
    List<UserDto> getAllUsers();

    Optional<User> getUserByEmail(String email);

    Optional<User> getUserByUsername(String username);

    Optional<User> getUserById(Long id);

    User ban(Optional<User> user);

    User addAdmin(Optional<User> user);


}
