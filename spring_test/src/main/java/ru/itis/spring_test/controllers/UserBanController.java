package ru.itis.spring_test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.spring_test.dto.SearchDto;
import ru.itis.spring_test.dto.UserDto;
import ru.itis.spring_test.models.User;
import ru.itis.spring_test.services.UsersService;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
public class UserBanController {
    @Autowired
    UsersService usersService;

    @PostMapping("/ban")
    public ResponseEntity<List<UserDto>> getSearchResultViaAjax(@Valid @RequestBody SearchDto searchDto, Errors errors) {
        Optional<User> user = usersService.getUserByUsername(searchDto.getUsername());
        usersService.ban(user);

        return ResponseEntity.ok(usersService.getAllUsers());
    }
}
