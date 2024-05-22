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

    public List<Card> getSellingCards() {
        return cardRepository.findByEnVente(true);
    }

    public Optional<Card> getCardByName(String name) {
        return Optional.ofNullable(cardRepository.findByName(name));
    }


    public void addCardToUser(Long idCard, Long userId) {
        Optional<User> userOpt = userRepository.findById(userId);
        Optional<Card> cardOpt = cardRepository.findById(idCard);
        if (userOpt.isPresent() && cardOpt.isPresent()) {
            User user = userOpt.get();
            Card card = cardOpt.get();
            if (card.getOwner() != null) {
                Optional<User> seller = userRepository.findById(card.getOwner().getId());
                if (seller.isPresent()) {
                    seller.get().setCredits(seller.get().getCredits() + card.getPrix());
                    userRepository.save(seller.get());
                }
            }
            user.getCards().add(card);
            card.setEnVente(false);
            card.setOwner(user);
            cardRepository.save(card);
            user.setCredits(user.getCredits() - card.getPrix());
            userRepository.save(user);
        } else {
            throw new RuntimeException("User not found");
        }
    }

    public void deleteCardFromUser(Card card, Long userId) {
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

    public void setIsSelling(Long idCard, boolean state) {
        Optional<Card> cardOpt = cardRepository.findById(idCard);
        if (cardOpt.isPresent()) {
            Card card = cardOpt.get();
            card.setEnVente(state);
            cardRepository.save(card);
        } else {
            throw new RuntimeException("Card not found");
        }
    }

    public void createCard(Card card, Long userId) {
        Optional<User> userOpt = userRepository.findById(userId);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            card.setOwner(user);
            card.setEnVente(false);
        } else {
            card.setEnVente(true);
        }
        cardRepository.save(card);
    }
}
