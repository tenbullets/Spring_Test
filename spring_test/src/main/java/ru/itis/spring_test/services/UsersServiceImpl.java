package ru.itis.spring_test.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.spring_test.dto.UserDto;
import ru.itis.spring_test.repository.UsersRepository;

import java.util.List;

import static ru.itis.spring_test.dto.UserDto.from;

@Component
public class UsersServiceImpl implements UsersService{

    @Autowired
    private UsersRepository usersRepository;
    @Override
    public List<UserDto> getAllUsers() {
        return from(usersRepository.findAll());
    }
}
