package com.example.testsecurity.entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String role;

    @Column(unique = true)
    private String userName;

    private String userPassword;

    @Builder
    public UserEntity(String role, String userName, String userPassword) {
        this.role = role == null ? "ROLE_A" : role;
        this.userName = userName;
        this.userPassword = userPassword;
    }
}
