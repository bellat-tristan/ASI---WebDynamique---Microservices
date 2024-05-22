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

    public void addCardToUser(Card card, Long userId) {
        Optional<User> userOpt = userRepository.findById(userId);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            Optional<User> seller = userRepository.findById(card.getOwnerId());
            if (!seller.isEmpty()){
                seller.get().setCredits(seller.get().getCredits() + card.getPrix());
                userRepository.save(seller.get());
            }

            user.getCards().add(card);
            card.setOwnerId(user.getId());
            cardRepository.save(card);
            user.setCredits(user.getCredits() - card.getPrix());
            userRepository.save(user);
        } else {
            throw new RuntimeException("User not found");
        }
    }
    public void deleteCardToUser(Card card, Long userId) {
        Optional<User> userOpt = userRepository.findById(userId);
        if (userOpt.isPresent()) {
            User user = userOpt.get();

            user.getCards().remove(card);
            user.setCredits(user.getCredits() + card.getPrix());
            userRepository.save(user);

        } else {
            throw new RuntimeException("User not found");
        }
    }

    public void setIsSelling(Card card, boolean state){
        card.setEnVente(state);
        cardRepository.save(card);
    }
}
