package com.roby.oui.SPCardGame.service;

import com.roby.oui.SPCardGame.model.Card;
import com.roby.oui.SPCardGame.model.StarterCard;
import com.roby.oui.SPCardGame.model.User;
import com.roby.oui.SPCardGame.repository.CardRepository;
import com.roby.oui.SPCardGame.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private CardService cardService;
    @Autowired
    private StarterCardService starterCardService;

    public Boolean createUser(User user) {
        User existingUser = userRepository.findByUsername(user.getUsername());
        if (existingUser == null){
            // Save the new user to the database
            User newUser = userRepository.save(user);
            List<Card> cardList = new ArrayList<>();
            List<StarterCard> starterCardList = starterCardService.fiveRandomCard();

            for (StarterCard starterCard : starterCardList) {
                Card card = new Card(starterCard.getName(), starterCard.getDescription(), starterCard.getImgUrl(), starterCard.getFamily(), starterCard.getAffinity(), starterCard.getHp(), starterCard.getEnergy(), starterCard.getAttack(), starterCard.getDefense(), starterCard.getPrix(),false,newUser);
                cardRepository.save(card);
                // cardList.add(new Card(starterCard.getName(), starterCard.getDescription(), starterCard.getImgUrl(), starterCard.getFamily(), starterCard.getAffinity(), starterCard.getHp(), starterCard.getEnergy(), starterCard.getAttack(), starterCard.getDefense(), starterCard.getPrix(),false,newUser));
            }
            return true;
        }
        return false;
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}


