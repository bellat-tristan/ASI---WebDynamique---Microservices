package com.roby.oui.SPCardGame.controller;

import com.roby.oui.SPCardGame.model.Card;
import com.roby.oui.SPCardGame.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cards")
public class CardController {
    @Autowired
    private CardService cardService;

    @RequestMapping(value = {"/buy"}, method = RequestMethod.POST)
    public ResponseEntity<Card> buyCard(Card card) {
        cardService.addCardToUser(card);
        return new ResponseEntity<>(card, HttpStatus.CREATED);
    }

    @RequestMapping(value = {"/sell"}, method = RequestMethod.POST)
    public ResponseEntity<Void> sellCard(Card card) {
        cardService.deleteCardToUser(card.getId());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = {"/card"}, method = RequestMethod.GET)
    public ResponseEntity<List<Card>> getAllCards() {
        List<Card> cards = cardService.getAllCards();
        return new ResponseEntity<>(cards, HttpStatus.OK);
    }
}
