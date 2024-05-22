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
    public ResponseEntity<Card> buyCard(Card card, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId != null) {
            cardService.addCardToUser(card, userId);
            return new ResponseEntity<>(card, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @RequestMapping(value = {"/sell"}, method = RequestMethod.POST)
    public ResponseEntity<Void> sellCard(@RequestBody Card card, boolean state) {
        cardService.setIsSelling(card, state);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = {"/card"}, method = RequestMethod.GET)
    public ResponseEntity<List<Card>> getAllCards() {
        List<Card> cards = cardService.getAllCards();
        return new ResponseEntity<>(cards, HttpStatus.OK);
    }

    @RequestMapping(value = {"/sellingCards"}, method = RequestMethod.GET)
    public ResponseEntity<List<Card>> getSellingCards() {
        List<Card> cards = cardService.getSellingCards();
        return new ResponseEntity<>(cards, HttpStatus.OK);
    }

<<<<<<< HEAD

=======
    @PostMapping("/addCards")
    public ResponseEntity<Card> addCard(@RequestBody CardFormDTO cardForm, HttpSession session) {
        Card card = new Card();
        card.setName(cardForm.getName());
        card.setDescription(cardForm.getDescription());
        card.setImgUrl(cardForm.getImgUrl());
        card.setFamily(cardForm.getFamily());
        card.setAffinity(cardForm.getAffinity());
        card.setHp(cardForm.getHp());
        card.setEnergy(cardForm.getEnergy());
        card.setAttack(cardForm.getAttack());
        card.setDefence(cardForm.getDefence());
        card.setPrix(cardForm.getPrix());

        Long userId = (Long) session.getAttribute("userId");
        if (userId != null) {
            cardService.addCardToUser(card, userId);
            return new ResponseEntity<>(card, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
>>>>>>> dca79378fd13f278f2cdc88eeac05036861cf2c1
}
