package com.fitness.userserci.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;
    private String firsName;
    private String lastName;

    @Enumerated(EnumType.STRING)
    private  UserRole role = UserRole.USER;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public LocalDateTime setUpdatedAt() {
        this.updatedAt = updatedAt;
        return null;
    }

    public LocalDateTime setCreatedAt() {
        this.createdAt = createdAt;
        return null;
    }
}
