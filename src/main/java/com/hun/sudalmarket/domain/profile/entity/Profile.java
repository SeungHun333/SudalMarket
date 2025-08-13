package com.hun.sudalmarket.domain.profile.entity;

import com.hun.sudalmarket.domain.BaseEntity;
import com.hun.sudalmarket.domain.user.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Profile extends BaseEntity {

    private String profileName;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "image_url", length = 1000)
    private String image;

    @Column(length = 500)
    private String message;

    @Builder
    private Profile(String profileName, User user, String image, String description) {
        this.profileName = profileName;
        this.user = user;
        this.image = image;
        this.message = description;
    }
}
