package com.roby.oui.SPCardGame.service;

import com.roby.oui.SPCardGame.model.Card;
import com.roby.oui.SPCardGame.model.User;
import com.roby.oui.SPCardGame.repository.CardRepository;
import com.roby.oui.SPCardGame.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class CardService {
    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private UserRepository userRepository;

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

    public void addCardToUser(Card card) {
        // TODO recupéré user
        User user =  new User();
        // -----------------
        user.getCards().add(card);
        user.setCredits(user.getCredits() + card.getPrix());
        userRepository.save(user);
    }
    public void deleteCardToUser(Long id) {
        // TODO recupéré user
        User user =  new User();
        // -----------------
        Optional<Card> card = cardRepository.findById(id);
        for (Card oneCard : user.getCards()){
            if (oneCard.getId() == id){
                user.getCards().remove(oneCard);
            }
        }
        user.setCredits(user.getCredits() + card.get().getPrix());
        userRepository.save(user);
    }
}
