package com.example.testsecurity.controller;


import com.example.testsecurity.dto.JoinDTO;
import com.example.testsecurity.entity.UserEntity;
import com.example.testsecurity.service.JoinService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class JoinController {

    private final JoinService joinService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    @GetMapping("/join")
    public String joinP() {
        return "join";
    }

    @PostMapping("/joinProc")
    public String joinProcess(@ModelAttribute JoinDTO joinDTO) {

        log.info("{}", joinDTO.toString());
        UserEntity build = UserEntity.builder()
                .userName(joinDTO.userName())
                .userPassword(bCryptPasswordEncoder.encode(joinDTO.password()))
                .build();

    joinService.joinProcess(build);
        return "redirect:/login";
    }
}
