package com.kshtriya.auth.auth_app.services.impl;

import com.kshtriya.auth.auth_app.dtos.UserDto;
import com.kshtriya.auth.auth_app.services.AuthService;
import com.kshtriya.auth.auth_app.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserService userService;

    @Override
    public UserDto registerUser(UserDto userDto) {

        // logic
        // verify email
        // verify password
        // default roles

        UserDto userDto1 = userService.createUser(userDto);
        return userDto1;
    }

}
