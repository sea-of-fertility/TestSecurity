package com.example.testsecurity.service;


import com.example.testsecurity.entity.UserEntity;
import com.example.testsecurity.exception.join.DuplicateUser;
import com.example.testsecurity.reposiroty.UseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoinService {

    private final UseRepository useRepository;

    public void joinProcess(UserEntity userEntity) {
        if (useRepository.existsByUserName(userEntity.getUserName())){
            throw new DuplicateUser("중복된 닉네임입니다.");
        }
        else
            useRepository.save(userEntity);

    }
}
