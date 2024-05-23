package com.roby.oui.SPCardGame.controller;

import com.roby.oui.SPCardGame.model.Card;
import com.roby.oui.SPCardGame.model.CardFormDTO;
import com.roby.oui.SPCardGame.service.CardService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.FileStore;
import java.util.List;

@RestController
@RequestMapping("/cards")
public class CardController {
    @Autowired
    private CardService cardService;

    @RequestMapping(value = {"/buy"}, method = RequestMethod.POST)
    public ResponseEntity<Boolean> buyCard(@RequestParam Long idCard, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId != null) {
            Boolean res = cardService.addCardToUser(idCard, userId);
            return new ResponseEntity<>(res, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @RequestMapping(value = {"/sell"}, method = RequestMethod.POST)
    public ResponseEntity<Void> sellCard( @RequestParam Long idCard, boolean state, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId != null) {
            cardService.setIsSelling(idCard, state);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @RequestMapping(value = {"/listAll"}, method = RequestMethod.GET)
    public ResponseEntity<List<Card>> getAllCards() {
        List<Card> cards = cardService.getAllCards();
        return new ResponseEntity<>(cards, HttpStatus.OK);
    }

    @RequestMapping(value = {"/addCards"}, method = RequestMethod.POST)
    public ResponseEntity<Card> addCard(@RequestBody Card card, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId != null) {
            cardService.createCard(card, userId);
            return new ResponseEntity<>(card, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}
