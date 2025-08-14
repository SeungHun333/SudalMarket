package com.hun.sudalmarket.domain.profile.dto.requset;

import jakarta.validation.constraints.NotBlank;

public record ProfileNameUpdateRequest(

        @NotBlank
        String profileName
) {
}
