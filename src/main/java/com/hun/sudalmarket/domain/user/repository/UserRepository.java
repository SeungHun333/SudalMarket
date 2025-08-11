package com.hun.sudalmarket.domain.user.repository;

import com.hun.sudalmarket.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmail(String email);
}
