package com.roby.oui.SPCardGame.controller;

import com.roby.oui.SPCardGame.model.Card;
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
    public ResponseEntity<Card> buyCard(Long idCard, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId != null) {
            cardService.addCardToUser(idCard, userId);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @RequestMapping(value = {"/sell"}, method = RequestMethod.POST)
    public ResponseEntity<Void> sellCard(Long idCard, boolean state) {
        cardService.setIsSelling(idCard, state);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = {"/cards"}, method = RequestMethod.GET)
    public ResponseEntity<List<Card>> getAllCards() {
        List<Card> cards = cardService.getAllCards();
        return new ResponseEntity<>(cards, HttpStatus.OK);
    }

    @RequestMapping(value = {"/sellingCards"}, method = RequestMethod.GET)
    public ResponseEntity<List<Card>> getSellingCards() {
        List<Card> cards = cardService.getSellingCards();
        return new ResponseEntity<>(cards, HttpStatus.OK);
    }
}
