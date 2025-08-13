package com.hun.sudalmarket.domain.profile.dto.requset;

import com.hun.sudalmarket.domain.profile.entity.Profile;
import com.hun.sudalmarket.domain.user.entity.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProfileRegisterRequest(

        @NotNull
        long userId,

        @NotBlank
        String profileName,

        String imageUrl,
        String message
) {
    public static Profile toEntity(ProfileRegisterRequest request, User user) {
        return Profile.builder()
                .profileName(request.profileName())
                .user(user)
                .description(request.message())
                .image(request.imageUrl())
                .build();
    }
}
