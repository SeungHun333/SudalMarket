package com.hun.sudalmarket.domain.profile.controller;

import com.hun.sudalmarket.domain.profile.dto.requset.ProfileRegisterRequest;
import com.hun.sudalmarket.domain.profile.entity.Profile;
import com.hun.sudalmarket.domain.profile.service.ProfileService;
import com.hun.sudalmarket.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/profiles")
public class ProfileController {

    private final ProfileService profileService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@Validated @RequestBody ProfileRegisterRequest request) {

        User user = profileService.getUserEntity(request.userId());
        Profile newProfile = ProfileRegisterRequest.toEntity(request, user);

        return ResponseEntity.ok(profileService.createProfile(newProfile));
    }
}
