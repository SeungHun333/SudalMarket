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

        userRepository.save(newUser);

        return "success";
    }
}
