package com.fitness.userserci.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserResponse {
        private String id;
        private String email;
        private String password;
        private String firsName;
        private String lastName;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
    }

