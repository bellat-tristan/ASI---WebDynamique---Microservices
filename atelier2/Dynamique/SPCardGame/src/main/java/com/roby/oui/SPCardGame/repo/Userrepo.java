package com.roby.oui.SPCardGame.repo;

import com.roby.oui.SPCardGame.model.User;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface Userrepo extends JpaRepository<User, Long> {
    Optional<SecurityProperties.User> findByUsername(String username);
}
