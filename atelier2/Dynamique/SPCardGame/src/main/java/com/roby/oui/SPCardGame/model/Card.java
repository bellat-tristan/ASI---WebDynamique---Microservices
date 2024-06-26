package com.roby.oui.SPCardGame.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import jakarta.persistence.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String imgUrl;
    private String family;
    private String affinity;
    private int hp;
    private int energy;
    private int attack;
    private int defense;
    private int prix;
    private boolean enVente;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id")
    @JsonIgnoreProperties({"cards"}) // Ignore the 'cards' field in User during serialization
    private User owner;

    public Card(String name, String description, String imgUrl, String family, String affinity, int hp, int energy, int attack, int defense, int prix) {
        this.name = name;
        this.description = description;
        this.imgUrl = imgUrl;
        this.family = family;
        this.affinity = affinity;
        this.hp = hp;
        this.energy = energy;
        this.attack = attack;
        this.defense = defense;
        this.prix = prix;
        this.enVente = false;
    }

    public Card(String name, String description, String imgUrl, String family, String affinity, int hp, int energy, int attack, int defense, int prix, boolean enVente, User owner) {
        this.name = name;
        this.description = description;
        this.imgUrl = imgUrl;
        this.family = family;
        this.affinity = affinity;
        this.hp = hp;
        this.energy = energy;
        this.attack = attack;
        this.defense = defense;
        this.prix = prix;
        this.enVente = enVente;
        this.owner = owner;
    }
}
