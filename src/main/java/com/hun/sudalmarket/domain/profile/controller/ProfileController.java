package com.hun.sudalmarket.domain.profile.controller;

import com.hun.sudalmarket.domain.profile.dto.requset.ProfileImageUpdateRequest;
import com.hun.sudalmarket.domain.profile.dto.requset.ProfileMessageUpdateRequest;
import com.hun.sudalmarket.domain.profile.dto.requset.ProfileNameUpdateRequest;
import com.hun.sudalmarket.domain.profile.dto.requset.ProfileRegisterRequest;
import com.hun.sudalmarket.domain.profile.entity.Profile;
import com.hun.sudalmarket.domain.profile.service.ProfileService;
import com.hun.sudalmarket.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    @PatchMapping("/{profile_id}/image")
    public ResponseEntity<String> updateProfileImage(@PathVariable("profile_id") Long profileId,
                                                     @RequestBody ProfileImageUpdateRequest request) {
        return ResponseEntity.ok(profileService.updateImage(profileId, request));
    }

    @PatchMapping("/{profile_id}/message")
    public ResponseEntity<String> updateProfileMessage(@PathVariable("profile_id") Long profileId,
                                                     @RequestBody ProfileMessageUpdateRequest request) {
        return ResponseEntity.ok(profileService.updateMessage(profileId, request));
    }

    @PatchMapping("/{profile_id}/name")
    public ResponseEntity<String> updateProfileName(@PathVariable("profile_id") Long profileId,
                                                     @RequestBody ProfileNameUpdateRequest request) {
        return ResponseEntity.ok(profileService.updateName(profileId, request));
    }
}
