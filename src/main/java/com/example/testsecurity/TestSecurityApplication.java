package com.example.testsecurity;

import com.example.testsecurity.entity.UserEntity;
import com.example.testsecurity.reposiroty.UseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
@RequiredArgsConstructor
public class TestSecurityApplication {

    private final UseRepository useRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(TestSecurityApplication.class, args);
    }


    @Bean
    public CommandLineRunner runner() {

        return args -> {
            UserEntity user1 = UserEntity.builder()
                    .userName("user1")
                    .role("A")
                    .userPassword(passwordEncoder.encode("1234"))
                    .build();

            UserEntity user2 = UserEntity.builder()
                    .userName("user2")
                    .role("B")
                    .userPassword(passwordEncoder.encode("1234"))
                    .build();

            UserEntity user3 = UserEntity.builder()
                    .userName("user3")
                    .role("C")
                    .userPassword(passwordEncoder.encode("1234"))
                    .build();


            useRepository.save(user1);
            useRepository.save(user2);
            useRepository.save(user3);
        };
    }

}
