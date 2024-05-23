package com.roby.oui.SPCardGame.service;

import com.roby.oui.SPCardGame.model.StarterCard;
import com.roby.oui.SPCardGame.repository.StarterCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class StarterCardService {
    @Autowired
    private StarterCardRepository starterCardRepository;

    List<StarterCard> fiveRandomCard(){
        List<StarterCard> starterCardList = starterCardRepository.findAll();
        Collections.shuffle(starterCardList);
        List<StarterCard> randomCards = starterCardList.subList(0, 5);
        return randomCards;
    }
}
