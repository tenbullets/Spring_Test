package ru.itis.spring_test.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.spring_test.dto.UserDto;
import ru.itis.spring_test.models.Banned;
import ru.itis.spring_test.models.Role;
import ru.itis.spring_test.models.Status;
import ru.itis.spring_test.models.User;
import ru.itis.spring_test.repository.UsersRepository;

import java.util.List;
import java.util.Optional;

import static ru.itis.spring_test.dto.UserDto.usersList;

@Component
public class UsersServiceImpl implements UsersService{

    @Autowired
    private UsersRepository usersRepository;


    @Override
    public List<UserDto> getAllUsers() {
        return usersList(usersRepository.findAll());
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return usersRepository.findByEmail(email);
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        return Optional.ofNullable(usersRepository.findUserByUsername(username));
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return usersRepository.findUserById(id);
    }

    @Override
    public User ban(Optional<User> user) {
        User u = usersRepository.getOne(user.get().getId());
        if(u.getBan_status().equals(Banned.NONBANNED)) {
            u.setBan_status(Banned.BANNED);
        } else {
            u.setBan_status(Banned.NONBANNED);
        }
        usersRepository.save(u);
        return u;
    }

    @Override
    public User addAdmin(Optional<User> user) {
        User u = usersRepository.getOne(user.get().getId());
        if(u.getRole().equals(Role.ADMIN)) {
            u.setRole(Role.USER);
        } else {
            u.setRole(Role.ADMIN);
        }
        usersRepository.save(u);
        return u;
    }

    @Override
    public User confirmUser(Optional<User> user) {
        User u = usersRepository.getOne(user.get().getId());
        if(u.getStatus().equals(Status.NON_CONFIRMED)) {
            u.setStatus(Status.CONFIRMED);
            u.setKey(null);
            usersRepository.save(u);
        }
        return u;
    }

}
