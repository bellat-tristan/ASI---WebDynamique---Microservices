package com.roby.oui.SPCardGame.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


import org.springframework.stereotype.Service;

import com.roby.oui.SPCardGame.model.Card;


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

        Card p1=new Card("Joh", "Test", "https://www.pokemon.com/static-assets/content-assets/cms2-fr-fr/img/cards/web/SVP/SVP_FR_47.png","Feu","affinity",23,34,15,29, 20);
        Card p2=new Card("Roberto", "Test", "https://www.pokemon.com/static-assets/content-assets/cms2-fr-fr/img/cards/web/SVP/SVP_FR_47.png","Feu","affinity",23,34,15,29, 30);
        Card p3=new Card("Anna", "Test", "https://www.pokemon.com/static-assets/content-assets/cms2-fr-fr/img/cards/web/SVP/SVP_FR_47.png","Feu","affinity",23,34,15,29, 5);
        Card p4=new Card("Angry Joe","Test", "https://www.pokemon.com/static-assets/content-assets/cms2-fr-fr/img/cards/web/SVP/SVP_FR_47.png","Feu","affinity",23,34,15,29, 34);
        Card p5=new Card("Ursula", "Test", "https://www.pokemon.com/static-assets/content-assets/cms2-fr-fr/img/cards/web/SVP/SVP_FR_47.png","Feu","affinity",23,34,15,29, 100);

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

    public Card addCard(String name, String description, String imgUrl, String family, String affinity, int hp, int energy, int attack, int defence, int prix) {
        Card p=new Card(name, description, imgUrl,family,affinity,hp,energy,attack,defence,prix);
        this.myCardList.add(p);
        return p;
    }
}

