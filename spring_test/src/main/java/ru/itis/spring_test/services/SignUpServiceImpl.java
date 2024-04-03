package ru.itis.spring_test.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.itis.spring_test.dto.UserForm;
import ru.itis.spring_test.models.Banned;
import ru.itis.spring_test.models.Role;
import ru.itis.spring_test.models.User;
import ru.itis.spring_test.repository.UsersRepository;

@Component
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsersRepository usersRepository;
    @Override
    public void addUser(UserForm userForm) {
        User user = User.builder()
                .email(userForm.getEmail())
                .password(passwordEncoder.encode(userForm.getPassword()))
                .username(userForm.getUsername())
                .status("CONFIRMED")
                .ban_status(Banned.NONBANNED)
                .role(Role.USER)
                .build();
        usersRepository.save(user);
    }
}
