package com.roby.oui.SPCardGame.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Card  {
    private String color;
    private String description;
    private String name;
    private String imgUrl;

    public Card() {
        this.color = "";
        this.description = "";
        this.name = "";
        this.imgUrl="";
    }
    public Card(String name,String color,String description, String imgUrl) {
        this.color = color;
        this.description = description;
        this.name = name;
        this.imgUrl=imgUrl;
    }
}

