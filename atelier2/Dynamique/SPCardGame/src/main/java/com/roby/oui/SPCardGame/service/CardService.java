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

    public List<Card> getUserCards(Long userId) {
        Optional<User> userOpt = userRepository.findById(userId);
        if (userOpt.isPresent()){
            User user = userOpt.get();
            return cardRepository.findByOwner(user);
        } else {
            throw new RuntimeException("User not found");
        }
    }

    public Card findCardByName(String name) {
        return cardRepository.findByName(name);
    }

    public Optional<Card> getCardByName(String name) {
        return Optional.ofNullable(cardRepository.findByName(name));
    }


    public Boolean addCardToUser(Long idCard, Long userId) {
        Optional<User> userOpt = userRepository.findById(userId);
        Optional<Card> cardOpt = cardRepository.findById(idCard);
        if (userOpt.isPresent() && cardOpt.isPresent()) {
            User user = userOpt.get();
            Card card = cardOpt.get();
            // ICI SI JE TROUVE PAS LE VENDEUR; JE DONNE PAS LES SOUS
            if (user.getCredits() >= card.getPrix()){
                if (card.getOwner() != null) {
                    Optional<User> seller = userRepository.findById(card.getOwner().getId());
                    if (seller.isPresent()) {
                        seller.get().setCredits(seller.get().getCredits() + card.getPrix());
                        userRepository.save(seller.get());
                    }
                }
                //user.getCards().add(card);
                card.setEnVente(false);
                card.setOwner(user);
                cardRepository.save(card);
                user.setCredits(user.getCredits() - card.getPrix());
                userRepository.save(user);
                return true;
            }
            System.out.println("L'utilisateur n'a pas assez d'argent");
            return false;

        } else {
            throw new RuntimeException("User not found");
        }
    }

    /*public void deleteCardFromUser(Card card, Long userId) {
        Optional<User> userOpt = userRepository.findById(userId);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            user.getCards().remove(card);
            user.setCredits(user.getCredits() + card.getPrix());
            userRepository.save(user);
        } else {
            throw new RuntimeException("User not found");
        }
    }*/

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
        // calcule du prix en fonction des paramètres de la carte
        int hp = card.getHp();
        int energy = card.getEnergy();
        int attack = card.getAttack();
        int defense = card.getDefense();

        int maxAttributeValue = 100;
        int maxPrice = 1000;

        int totalValue = hp + energy + attack + defense;
        double percentage = (double) totalValue / (4 * maxAttributeValue);
        double rawPrice = percentage * maxPrice;
        Random random = new Random();
        double price = rawPrice * (0.9 + random.nextDouble() * 0.2);
        int intPrice = (int) price;
        if (intPrice < 1)
            intPrice = 1;
        else if (intPrice > 1000) {
            intPrice = 1000;
        }

        card.setPrix(intPrice);
        card.setEnVente(true);
        cardRepository.save(card);
    }
}
