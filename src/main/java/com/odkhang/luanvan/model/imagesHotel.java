package com.odkhang.luanvan.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(value = "images")
public class imagesHotel {
    @Id
    private String id;
    @Field(value = "idHouse")
    private Long idHouse;
    @Field(value = "imgLink")
    private String imgLink;

    public imagesHotel() {
    }

    public imagesHotel(String id, Long idHouse, String imgLink) {
        this.id = id;
        this.idHouse = idHouse;
        this.imgLink = imgLink;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getIdHouse() {
        return idHouse;
    }

    public void setIdHouse(Long idHouse) {
        this.idHouse = idHouse;
    }

    public String getImgLink() {
        return imgLink;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }

}
