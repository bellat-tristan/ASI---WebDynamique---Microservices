package com.roby.oui.SPCardGame.controller;

import com.roby.oui.SPCardGame.model.Card;
import com.roby.oui.SPCardGame.service.CardService;
import jakarta.servlet.http.HttpSession;
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
    public ResponseEntity<Card> buyCard(@RequestBody Card card, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId != null) {
            cardService.addCardToUser(userId, card);
            return new ResponseEntity<>(card, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/sell")
    public ResponseEntity<Void> sellCard(@RequestBody Long cardId, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId != null) {
            cardService.deleteCardToUser(userId, cardId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping
    public ResponseEntity<List<Card>> getAllCards() {
        List<Card> cards = cardService.getAllCards();
        return new ResponseEntity<>(cards, HttpStatus.OK);
    }
}
