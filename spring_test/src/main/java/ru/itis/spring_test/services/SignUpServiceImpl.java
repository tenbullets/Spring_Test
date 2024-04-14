package ru.itis.spring_test.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.itis.spring_test.dto.UserForm;
import ru.itis.spring_test.models.Banned;
import ru.itis.spring_test.models.Role;
import ru.itis.spring_test.models.User;
import ru.itis.spring_test.repository.UsersRepository;

import java.util.Random;

@Component
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    SmsService smsService;

    @Override
    public void addUser(UserForm userForm) {
        String activationKey = getActivationKey();

        User user = User.builder()
                .email(userForm.getEmail())
                .password(passwordEncoder.encode(userForm.getPassword()))
                .username(userForm.getUsername())
                .status("NON-CONFIRMED")
                .ban_status(Banned.NONBANNED)
                .role(Role.USER)
                .phone(userForm.getPhone())
                .key(activationKey)
                .build();
        usersRepository.save(user);

        String msg = activationKey + " — your account activation code";
//        System.out.println(msg);
        // закомитить ниже, если нет денег на балансе)
//        smsService.sendSms(user.getPhone(), msg);
    }

    public String getActivationKey() {
        Random random = new Random();
        StringBuilder key = new StringBuilder(String.format("%06d", random.nextInt(1000000)));
        key.insert(3,"-");
        return key.toString();
    }
}
