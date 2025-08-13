package com.hun.sudalmarket.domain.profile.repository;

import com.hun.sudalmarket.domain.profile.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

}
