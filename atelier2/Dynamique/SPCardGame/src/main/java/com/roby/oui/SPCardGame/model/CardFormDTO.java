package com.roby.oui.SPCardGame.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CardFormDTO {

    private String name;
    private String description;
    private String imgUrl;
    private String family;
    private String affinity;
    private int hp;
    private int energy;
    private int attack;
    private int defence;
    private int prix;


    public CardFormDTO() {
        this.description = "";
        this.name = "";
        this.imgUrl = "";
        this.affinity="";
        this.family="";
        this.hp=0;
        this.energy=0;
        this.attack=0;
        this.defence=0;
        this.prix=0;
    }
}



