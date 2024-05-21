package com.roby.oui.SPCardGame.service;

import com.roby.oui.SPCardGame.model.Card;
import com.roby.oui.SPCardGame.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class CardService {
    @Autowired
    private CardRepository cardRepository;

    private Random randomGenerator = new Random();

    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }

    public Optional<Card> getCardByName(String name) {
        return Optional.ofNullable(cardRepository.findByName(name));
    }

    public Card getRandomCard() {
        List<Card> cards = cardRepository.findAll();
        int index = randomGenerator.nextInt(cards.size());
        return cards.get(index);
    }

    public Card addCard(String name, String description, String imgUrl, String family, String affinity, int hp, int energy, int attack, int defence, float prix) {
        Card card = new Card(name, description, imgUrl, family, affinity, hp, energy, attack, defence, prix);
        return cardRepository.save(card);
    }
    public void deleteCard(Long id) {
        cardRepository.deleteById(id);
    }
}
