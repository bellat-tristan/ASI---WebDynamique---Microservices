package com.roby.oui.SPCardGame.model;
import jakarta.persistence.*;
import org.springframework.data.annotation.Id;
import java.util.HashSet;
import java.util.Set;
@Entity
public class Card {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String color;
    private String description;
    private String name;
    private String imgUrl;

    @ManyToOne
    private user owner;

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

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getImgUrl() {
        return imgUrl;
    }
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
    public void setId(Long id) {this.id = id;}
    public Long getId() {return id;}
}

