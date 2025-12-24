package com.fitness.userserci.service;

import com.fitness.userserci.dto.RegisterRequest;
import com.fitness.userserci.dto.UserResponse;
import com.fitness.userserci.model.User;
import com.fitness.userserci.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public UserResponse register(@Valid RegisterRequest request) {

        if (repository.existsByEmail(request.getEmail())){
            throw new RuntimeException("Email already exist");
        }

        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setFirsName(request.getFirstName());
        user.setLastName(request.getLastName());

        User savedUser = repository.save(user);
        UserResponse userResponse = new UserResponse();
        userResponse.setId(savedUser.getId());
        userResponse.setPassword(savedUser.getPassword());
        userResponse.setEmail(savedUser.getEmail());
        userResponse.setFirsName(savedUser.getFirsName());
        userResponse.setLastName(savedUser.getLastName());
        userResponse.setCreatedAt(savedUser.setCreatedAt());
        userResponse.setUpdatedAt(savedUser.setUpdatedAt());

        return  userResponse;
    }

    public UserResponse getUserProfile(String userId) {
        User user = repository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User Boy Found"));

            UserResponse userResponse = new UserResponse();
            userResponse.setId(user.getId());
            userResponse.setPassword(user.getPassword());
            userResponse.setEmail(user.getEmail());
            userResponse.setFirsName(user.getFirsName());
            userResponse.setLastName(user.getLastName());
            userResponse.setCreatedAt(user.setCreatedAt());
            userResponse.setUpdatedAt(user.setUpdatedAt());

            return userResponse;

    }
}
