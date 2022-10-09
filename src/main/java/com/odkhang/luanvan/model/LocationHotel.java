package com.odkhang.luanvan.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(value = "locations")
public class LocationHotel {
    @Id
    private String id;
    private Long idLocation;
    private String name;
    private String image;
}
