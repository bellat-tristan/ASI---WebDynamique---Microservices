package com.sp.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PoneyFormDTO {

    private String color;
    private String superPower;
    private String name;
    private String imgUrl;

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public PoneyFormDTO() {
        this.color = "";
        this.superPower = "";
        this.name = "";
        this.imgUrl = "";
    }

    public PoneyFormDTO(String name, String color, String superPower, String imgUrl) {
        this.color = color;
        this.superPower = superPower;
        this.name = name;
        this.imgUrl = imgUrl;
    }
}