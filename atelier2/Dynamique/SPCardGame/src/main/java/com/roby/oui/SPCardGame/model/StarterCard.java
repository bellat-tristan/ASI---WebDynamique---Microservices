package com.roby.oui.SPCardGame.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class StarterCard {
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

    public StarterCard(String name, String description, String imgUrl, String family, String affinity, int hp, int energy, int attack, int defense, int prix) {
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
    }
}
