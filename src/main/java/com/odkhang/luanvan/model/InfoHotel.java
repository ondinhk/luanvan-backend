package com.odkhang.luanvan.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(value = "Hotels")
public class InfoHotel {
    @Id
    private String id;
    @Field(value = "name")
    private String name;
    private Long idLocation;
    private String idLocationName;
    private String address;
    @Field(value = "geo_code")
    private Object geoCode;
    @Field(value = "cost_original")
    private String costOriginal;
    @Field(value = "cost_sale")
    private String costSale;
    private float rate;
    public int number_reviews;
    private String description;
    @Field(value = "facility")
    private Object facility;
    @Field(value = "location_recent")
    private Object locationRecent;
    @Field(value = "locations_distance")
    private Object locationsDistance;
    @Field(value = "images")
    private Object images;
}
