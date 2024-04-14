package ru.itis.spring_test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ru.itis.spring_test.dto.SearchDto;
import ru.itis.spring_test.models.AjaxResponseBody;
import ru.itis.spring_test.models.User;
import ru.itis.spring_test.services.UsersService;
import javax.validation.Valid;
import java.sql.SQLOutput;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class SearchController {

    @Autowired
    UsersService usersService;

    @PostMapping("/search")
    public ResponseEntity<?> getSearchResultViaAjax(@Valid @RequestBody SearchDto searchDto, Errors errors) {
        AjaxResponseBody result = new AjaxResponseBody();

        if(errors.hasErrors()) {
            result.setMsg(errors.getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(",")));
            return ResponseEntity.badRequest().body(result);
        }

        Optional<User> userList = usersService.getUserByUsername(searchDto.getUsername());

        if(userList.isEmpty())
            result.setMsg("no user found");
        else
            result.setMsg("success");

        result.setResult(userList);

        return ResponseEntity.ok(result);
    }

}
