package com.odkhang.luanvan.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(value = "Rating_recommend")
public class RatingRecommend {
    @Id
    private String id;
    @Field(value = "Rate")
    private int rate;
    @Field(value = "Recommend_for")
    private String recommend_for;
    @Field(value = "Recommend")
    private String recommend;
    @Field(value = "Comment")
    private String comment;
}
