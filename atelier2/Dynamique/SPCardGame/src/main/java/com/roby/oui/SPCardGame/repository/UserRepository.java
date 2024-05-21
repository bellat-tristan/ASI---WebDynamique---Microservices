package com.roby.oui.SPCardGame.repository;

import com.roby.oui.SPCardGame.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

