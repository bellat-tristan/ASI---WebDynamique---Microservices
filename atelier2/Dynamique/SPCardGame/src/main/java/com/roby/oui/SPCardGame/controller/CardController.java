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

    @PostMapping("/buy")
    public ResponseEntity<Card> buyCard(@RequestBody Card card) {
        Card newCard = cardService.addCard(card.getName(), card.getColor(), card.getDescription(), card.getImgUrl());
        return new ResponseEntity<>(newCard, HttpStatus.CREATED);
    }

    @PostMapping("/sell")
    public ResponseEntity<Void> sellCard(@RequestBody Long cardId) {
        cardService.deleteCard(cardId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<Card>> getAllCards() {
        List<Card> cards = cardService.getAllCards();
        return new ResponseEntity<>(cards, HttpStatus.OK);
    }
}
