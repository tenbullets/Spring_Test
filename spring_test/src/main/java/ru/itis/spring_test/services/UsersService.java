package ru.itis.spring_test.services;

import ru.itis.spring_test.dto.UserDto;

import java.util.List;

public interface UsersService {
    List<UserDto> getAllUsers();
}
