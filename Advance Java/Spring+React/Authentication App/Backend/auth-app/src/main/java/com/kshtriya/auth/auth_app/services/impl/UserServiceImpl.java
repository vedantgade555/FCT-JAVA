package com.kshtriya.auth.auth_app.services.impl;

import com.kshtriya.auth.auth_app.dtos.UserDto;
import com.kshtriya.auth.auth_app.entity.Provider;
import com.kshtriya.auth.auth_app.entity.User;
import com.kshtriya.auth.auth_app.exceptions.ResourceNotFoundException;
import com.kshtriya.auth.auth_app.helper.UserHelper;
import com.kshtriya.auth.auth_app.repositories.UserRepository;
import com.kshtriya.auth.auth_app.services.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

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
    @Transactional
    public UserDto updateUser(UserDto userDto, String userId) {
        UUID uid = UserHelper.parseUUID(userId);
        User existingUser = userRepository.findById(uid).orElseThrow(() -> new ResourceNotFoundException("User Id not found with given id"));

        // We are not change email id in this project due to security issue
        if(userDto.getName() != null) existingUser.setName(userDto.getName());
        if(userDto.getImage() != null) existingUser.setImage(userDto.getImage());

        if(userDto.getProvider() != null) existingUser.setProvider(userDto.getProvider());
        // TODO: change the password updation logic
        if(userDto.getPassword() != null) existingUser.setPassword(userDto.getPassword());

        // Assuming getEnable() returns a boolean or Boolean.
        // Note: You might want a null check here if userDto.getEnable() can be null.
        if(userDto.getEnable() != null) existingUser.setEnable(userDto.getEnable());
        existingUser.setUpdatedAt(Instant.now());
        User updatedUser = userRepository.save(existingUser);

        return modelMapper.map(updatedUser, UserDto.class);
    }

    @Override
    @Transactional
    public void deleteUser(String userId) {
        UUID uId = UserHelper.parseUUID(userId);
        User user = userRepository.findById(uId).orElseThrow(() -> new ResourceNotFoundException("User Id not found"));
        userRepository.delete(user);
    }

    @Override
    public UserDto getUserById(String userId) {
        User user = userRepository.findById(UserHelper.parseUUID(userId)).orElseThrow(() -> new ResourceNotFoundException("User Id not found"));
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public Iterable<UserDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .toList();
    }
}