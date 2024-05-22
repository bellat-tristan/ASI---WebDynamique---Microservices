package com.roby.oui.SPCardGame.model;

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
    private int defence;
    private int prix;
    private boolean enVente;

    // @ManyToOne(fetch = FetchType.EAGER, optional = true)
    private Long ownerId;

    public Card(String name, String description, String imgUrl, String family, String affinity, int hp, int energy, int attack, int defence, int prix) {
        this.name = name;
        this.description = description;
        this.imgUrl = imgUrl;
        this.family = family;
        this.affinity = affinity;
        this.hp = hp;
        this.energy = energy;
        this.attack = attack;
        this.defence = defence;
        this.prix = prix;
        this.enVente = false;
    }
}
