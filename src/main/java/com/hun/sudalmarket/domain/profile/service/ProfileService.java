package com.hun.sudalmarket.domain.profile.service;

import com.hun.sudalmarket.domain.profile.entity.Profile;
import com.hun.sudalmarket.domain.profile.repository.ProfileRepository;
import com.hun.sudalmarket.domain.user.entity.User;
import com.hun.sudalmarket.domain.user.repository.UserRepository;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
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
}
