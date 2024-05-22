package com.roby.oui.SPCardGame.service;

import com.roby.oui.SPCardGame.model.Card;
import com.roby.oui.SPCardGame.model.User;
import com.roby.oui.SPCardGame.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CardService cardService;

    public Boolean createUser(User user) {
        User existingUser = userRepository.findByUsername(user.getUsername());
        if (existingUser != null){
            // Save the new user to the database
            User newUser = userRepository.save(user);

        // Add 5 default cards to the new user
        Set<Card> defaultCards = new HashSet<>();
        defaultCards.add(new Card("Joh", "Test", "https://www.pokemon.com/static-assets/content-assets/cms2-fr-fr/img/cards/web/SVP/SVP_FR_47.png","Feu","affinity",23,34,15,29, 20));
        defaultCards.add(new Card("Roberto", "Test", "https://www.pokemon.com/static-assets/content-assets/cms2-fr-fr/img/cards/web/SVP/SVP_FR_47.png","Feu","affinity",23,34,15,29, 30));
        defaultCards.add(new Card("Anna", "Test", "https://www.pokemon.com/static-assets/content-assets/cms2-fr-fr/img/cards/web/SVP/SVP_FR_47.png","Feu","affinity",23,34,15,29, 5));
        defaultCards.add(new Card("Angry Joe","Test", "https://www.pokemon.com/static-assets/content-assets/cms2-fr-fr/img/cards/web/SVP/SVP_FR_47.png","Feu","affinity",23,34,15,29, 34));
        defaultCards.add(new Card("Ursula", "Test", "https://www.pokemon.com/static-assets/content-assets/cms2-fr-fr/img/cards/web/SVP/SVP_FR_47.png","Feu","affinity",23,34,15,29, 100));

        // Convertir l'ensemble en liste
        List<Card> defaultCardList = new ArrayList<>(defaultCards);

            newUser.setCards(defaultCardList);
            userRepository.save(newUser);
            return true;
        }
        return false;
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}


