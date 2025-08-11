package com.hun.sudalmarket.domain.user.service;

import com.hun.sudalmarket.domain.user.entity.User;
import com.hun.sudalmarket.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public String signUp(User newUser) {

        if(userRepository.existsByEmail(newUser.getEmail())) {
            throw new IllegalArgumentException("이미 사용 중이 이메일 입니다.");
        }

        userRepository.save(newUser);
        return "success";
    }
}
