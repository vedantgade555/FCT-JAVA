package com.kshtriya.auth.auth_app.services;

import com.kshtriya.auth.auth_app.dtos.UserDto;
import com.kshtriya.auth.auth_app.entity.Provider;
import com.kshtriya.auth.auth_app.entity.User;
import com.kshtriya.auth.auth_app.exceptions.ResourceNotFoundException;
import com.kshtriya.auth.auth_app.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
//import org.modelmapper.ModelMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public UserDto createUser(UserDto userDto) {
        // 1. Validation
        if (userDto.getEmail() == null || userDto.getEmail().isBlank()) {
            throw new IllegalArgumentException("Email is required");
        }

        if (userRepository.existsByEmail(userDto.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }

        // 2. Map DTO to Entity
        User user = modelMapper.map(userDto, User.class);

        // 3. Set Provider with correct null check
        Provider provider = userDto.getProvider() != null ? userDto.getProvider() : Provider.LOCAL;
        user.setProvider(provider);

        // 4. Save to Database
        // Role assign here to user for authorization
        // TODO
        User savedUser = userRepository.save(user);

        // 5. Map Entity back to DTO and return
        return modelMapper.map(savedUser, UserDto.class);
    }

    @Override
    public UserDto getUserByEmail(String email) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("User Email not found"));
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public UserDto updateUser(UserDto userDto, String userId) {
        return null; // TODO: Implement
    }

    @Override
    public UserDto deleteUser(String userId) {
        return null; // TODO: Implement
    }

    @Override
    public UserDto getUserById(String userId) {
        // Fetch the user or throw an exception if not found
        return null;
    }

    @Override
    public Iterable<UserDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(user -> modelMapper.map(user, UserDto.class)) // Fixed lambda syntax here
                .toList();
    }
}