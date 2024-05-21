package com.roby.oui.SPCardGame.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import com.roby.oui.SPCardGame.model.Card;

import org.springframework.stereotype.Service;


@Service
public class CardDao {
    private List<Card> myCardList;
    private Random randomGenerator;

    public CardDao() {
        myCardList=new ArrayList<>();
        randomGenerator = new Random();
        createCardList();
    }

    private void createCardList() {

        Card p1=new Card("John", "pink", "Test", "https://www.pokemon.com/static-assets/content-assets/cms2-fr-fr/img/cards/web/SVP/SVP_FR_47.png");
        Card p2=new Card("Roberto", "blue", "Test", "https://www.pokemon.com/static-assets/content-assets/cms2-fr-fr/img/cards/web/SVP/SVP_FR_47.png");
        Card p3=new Card("Anna", "orange", "Test", "https://www.pokemon.com/static-assets/content-assets/cms2-fr-fr/img/cards/web/SVP/SVP_FR_47.png");
        Card p4=new Card("Angry Joe", "purple", "Test", "https://www.pokemon.com/static-assets/content-assets/cms2-fr-fr/img/cards/web/SVP/SVP_FR_47.png");
        Card p5=new Card("Ursula", "green", "Test", "https://www.pokemon.com/static-assets/content-assets/cms2-fr-fr/img/cards/web/SVP/SVP_FR_47.png");

        myCardList.add(p1);
        myCardList.add(p2);
        myCardList.add(p3);
        myCardList.add(p4);
        myCardList.add(p5);
    }
    public List<Card> getCardList() {
        return this.myCardList;
    }
    public Card getCardByName(String name){
        for (Card cardBean : myCardList) {
            if(cardBean.getName().equals(name)){
                return cardBean;
            }
        }
        return null;
    }
    public Card getRandomCard(){
        int index=randomGenerator.nextInt(this.myCardList.size());
        return this.myCardList.get(index);
    }

    public Card addCard(String name, String color, String description, String imgUrl) {
        Card p=new Card(name, color, description, imgUrl);
        this.myCardList.add(p);
        return p;
    }
}

