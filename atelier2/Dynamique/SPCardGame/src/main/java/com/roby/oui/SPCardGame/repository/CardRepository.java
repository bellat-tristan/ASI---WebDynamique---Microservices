package com.roby.oui.SPCardGame.repository;

import com.roby.oui.SPCardGame.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {
    Card findByName(String name);
}