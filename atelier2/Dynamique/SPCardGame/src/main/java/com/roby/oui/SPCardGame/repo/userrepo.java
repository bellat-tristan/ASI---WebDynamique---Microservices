package com.roby.oui.SPCardGame.repo;

import com.roby.oui.SPCardGame.model.user;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface userrepo extends JpaRepository<user, Long> {
    Optional<SecurityProperties.User> findByUsername(String username);
}
