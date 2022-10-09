package com.odkhang.luanvan.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(value = "Hotels")
public class InfoHotel {
    @Id
    private String id;
    private String idHouse;
    private String name;
    private Object images;
    private String costOriginal;
    private String costNew;
    private String numberOfComment;
    private String rate;
    private String label;
    private int category;
    private String description;
}
