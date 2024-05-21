package com.roby.oui.SPCardGame.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CardFormDTO {

    private String color;
    private String description;
    private String name;
    private String imgUrl;


    public CardFormDTO() {
        this.color = "";
        this.description = "";
        this.name = "";
        this.imgUrl = "";
    }

    public CardFormDTO(String name, String color, String description, String imgUrl) {
        this.color = color;
        this.description = description;
        this.name = name;
        this.imgUrl = imgUrl;
    }
}



