package com.hun.sudalmarket.domain.profile.service;

import com.hun.sudalmarket.domain.profile.dto.requset.ProfileImageUpdateRequest;
import com.hun.sudalmarket.domain.profile.dto.requset.ProfileMessageUpdateRequest;
import com.hun.sudalmarket.domain.profile.dto.requset.ProfileNameUpdateRequest;
import com.hun.sudalmarket.domain.profile.entity.Profile;
import com.hun.sudalmarket.domain.profile.repository.ProfileRepository;
import com.hun.sudalmarket.domain.user.entity.User;
import com.hun.sudalmarket.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ProfileService {

    private final ProfileRepository profileRepository;
    private final UserRepository userRepository;


    public User getUserEntity(long userId) {
        return userRepository.findById(userId).orElseThrow();
    }

    public String createProfile(Profile newProfile) {
        profileRepository.save(newProfile);

        return "success";
    }

    public String updateImage(long profileId, ProfileImageUpdateRequest request) {
        Profile profile = profileRepository.findById(profileId).orElseThrow();
        profile.updateImage(request.imageUrl());

        return "success";
    }

    public String updateMessage(long profileId, ProfileMessageUpdateRequest request) {
        Profile profile = profileRepository.findById(profileId).orElseThrow();
        profile.updateMessage(request.message());

        return "success";
    }

    public String updateName(long profileId, ProfileNameUpdateRequest request) {
        Profile profile = profileRepository.findById(profileId).orElseThrow();
        profile.updateMessage(request.profileName());

        return "success";
    }
}
