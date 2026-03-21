package com.kshtriya.auth.auth_app.services;

import com.kshtriya.auth.auth_app.dtos.UserDto;
import com.kshtriya.auth.auth_app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        return null;
    }

    @Override
    public UserDto updateUser(UserDto userDto, String userId) {
        return null;
    }

    @Override
    public UserDto deleteUser(String userId) {
        return null;
    }
}
