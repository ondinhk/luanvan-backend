package com.odkhang.luanvan.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(value = "Locations")
public class LocationHotel {
    @Id
    private String id;
    @Field("idName")
    private String idName;
    @Field("idLocation")
    private Long idLocation;
    private String name;
    private String image;
    private int page;
    private String describe;
}
