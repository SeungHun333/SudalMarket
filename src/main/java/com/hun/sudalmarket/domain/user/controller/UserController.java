package com.hun.sudalmarket.domain.user.controller;

import com.hun.sudalmarket.domain.user.dto.request.UserSignUpRequest;
import com.hun.sudalmarket.domain.user.dto.response.UserSignUpResponse;
import com.hun.sudalmarket.domain.user.entity.User;
import com.hun.sudalmarket.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @PostMapping("/sign-up")
    public ResponseEntity<String> signUp(@Validated @RequestBody UserSignUpRequest request) {

        User newUser = UserSignUpRequest.toEntity(request);
        String response = userService.signUp(newUser);
        return ResponseEntity.ok(response);
    }
}
