package com.sp.model;

<<<<<<< HEAD
=======
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
>>>>>>> main
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
<<<<<<< HEAD

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSuperPower() {
        return superPower;
    }

    public void setSuperPower(String superPower) {
        this.superPower = superPower;
    }

    // Ajoute les getters et les setters pour 'name' et 'imgUrl' ici

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}



=======
}
>>>>>>> main
