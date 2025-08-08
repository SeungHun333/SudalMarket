package com.hun.sudalmarket.domain.user.entity;

import com.hun.sudalmarket.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "users")
@NoArgsConstructor
public class User extends BaseEntity {

    private String username;
    private String password;
    private String phone;
    private String email;

    @Builder
    private User(String username, String password, String phone, String email) {
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.email = email;
    }
}
