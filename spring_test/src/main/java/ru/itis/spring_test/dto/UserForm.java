package ru.itis.spring_test.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserForm {
    private String email;
    private String password;
    private String passwordCheck;
    private String username;
    private String phone;
    private String key;
}
