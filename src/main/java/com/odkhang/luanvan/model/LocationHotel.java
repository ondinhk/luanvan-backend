package com.odkhang.luanvan.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(value = "Locations")
public class LocationHotel {
    @Id
    private String id;
    private Long idLocation;
    private String Name;
    private String Image;
    private String Describe;
}
