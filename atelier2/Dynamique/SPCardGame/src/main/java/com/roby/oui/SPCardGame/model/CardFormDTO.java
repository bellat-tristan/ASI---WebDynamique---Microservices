package com.roby.oui.SPCardGame.model;

public class CardFormDTO {

    private String color;
    private String description;
    private String name;
    private String imgUrl;

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

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
}



