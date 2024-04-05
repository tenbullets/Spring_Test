package ru.itis.spring_test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.spring_test.dto.SearchDto;
import ru.itis.spring_test.dto.UserDto;
import ru.itis.spring_test.models.User;
import ru.itis.spring_test.security.details.UserDetailsImpl;
import ru.itis.spring_test.services.UsersService;
import javax.validation.Valid;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Optional;

@RestController
public class UserBanController {
    @Autowired
    UsersService usersService;

    @PostMapping("/ban")
    public ResponseEntity<List<UserDto>> getSearchResultViaAjax(@Valid @RequestBody SearchDto searchDto,
                                                                @AuthenticationPrincipal UserDetailsImpl userDetails)
    {
        String username = searchDto.getUsername();

        if(userDetails.getUsername().equals(username)) {
            return ResponseEntity.badRequest().body(usersService.getAllUsers());
        } else {
            Optional<User> user = usersService.getUserByUsername(username);
            usersService.ban(user);
            return ResponseEntity.ok(usersService.getAllUsers());
        }
    }
}
