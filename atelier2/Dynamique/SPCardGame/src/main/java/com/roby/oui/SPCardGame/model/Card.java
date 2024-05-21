package com.roby.oui.SPCardGame.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String color;
    private String description;
    private String name;
    private String imgUrl;

    @ManyToOne
    private User owner;

    public Card() {
        this.color = "";
        this.description = "";
        this.name = "";
        this.imgUrl = "";
    }

    public Card(String name, String color, String description, String imgUrl) {
        this.color = color;
        this.description = description;
        this.name = name;
        this.imgUrl = imgUrl;
    }
}

