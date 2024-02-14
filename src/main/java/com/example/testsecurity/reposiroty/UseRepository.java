package com.example.testsecurity.reposiroty;


import com.example.testsecurity.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UseRepository extends JpaRepository<UserEntity, Long > {
    boolean existsByUserName(String userName);

    Optional<UserEntity> findByUserName(String userName);
}
