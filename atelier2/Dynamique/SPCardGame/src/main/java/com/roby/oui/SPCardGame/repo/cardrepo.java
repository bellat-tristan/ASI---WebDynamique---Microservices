package com.roby.oui.SPCardGame.repo;

import com.roby.oui.SPCardGame.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface cardrepo extends JpaRepository<Card, Long> {
}
