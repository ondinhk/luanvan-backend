package com.odkhang.luanvan.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(value = "InfoHotels")
public class InfoHotel {
    @Id
    private String id;
    private Long idHouse;
    private Long idLocation;
    private String name;
    private String address;
    private String costOriginal;
    private String costNew;
    private String numberOfComment;
    private String rate;
    private String label;
    private String description;
    private Object images;
}
