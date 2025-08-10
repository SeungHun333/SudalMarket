package com.hun.sudalmarket.domain.user.dto.request;

import com.hun.sudalmarket.domain.user.entity.User;
import jakarta.validation.constraints.NotBlank;

public record UserSignUpRequest(

        @NotBlank(message = "이름은 필수 입력사항입니다.")
        String username,

        @NotBlank(message = "비밀번호는 필수 입력사항입니다.")
        String password,

        @NotBlank(message = "연락처는 필수 입력사항입니다.")
        String phone,

        @NotBlank(message = "이메일은 필수 입력사항입니다.")
        String email
) {

        public static User toEntity(UserSignUpRequest request) {
                return User.builder()
                        .username(request.username)
                        .password(request.password)
                        .phone(request.phone)
                        .email(request.email)
                        .build();
        }
}
