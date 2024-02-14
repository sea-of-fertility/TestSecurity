package com.example.testsecurity.service;

import com.example.testsecurity.entity.UserEntity;
import com.example.testsecurity.reposiroty.UseRepository;
import org.assertj.core.api.Assertions;
import org.hibernate.dialect.TiDBDialect;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class CustomUserDetailsServiceTest {

    @Autowired
    private UseRepository useRepository;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @BeforeEach
    public void setUseRepository() {
        useRepository.deleteAll();
    }

    @Test
    public void test1() throws Exception {
        //given
        UserEntity build = UserEntity.builder().userName("b")
                .userPassword("a")
                .build();

        useRepository.save(build);
        //when
        Optional<UserEntity> byUserName = useRepository.findByUserName(build.getUserName());
        //then
        Assertions.assertThat(byUserName).isPresent();
    }

    @Test
    public void test2() throws Exception {
        //given
        UserEntity build = UserEntity.builder().userName("b")
                .userPassword("a")
                .build();
        useRepository.save(build);

        //when
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(build.getUserName());

        System.out.println(userDetails.getUsername());

        //then
    }

}