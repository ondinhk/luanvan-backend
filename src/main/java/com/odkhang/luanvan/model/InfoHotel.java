package com.odkhang.luanvan.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(value = "house")
public class InfoHotel {
    @Id
    private String idHouse;
    private String title;
    private String linkBooking;
    private String image;
    private Object description;
    private String distance;
    private String cost;
    private String quanlityComment;
    private String rate;
    private String label_rate;

    @Override
    public String toString() {
        return "InfoHotel{" +
                "idHouse='" + idHouse + '\'' +
                ", title='" + title + '\'' +
                ", linkBooking='" + linkBooking + '\'' +
                ", image='" + image + '\'' +
                ", description='" + description + '\'' +
                ", distance='" + distance + '\'' +
                ", cost='" + cost + '\'' +
                ", quanlityComment='" + quanlityComment + '\'' +
                ", rate='" + rate + '\'' +
                ", label_rate='" + label_rate + '\'' +
                '}';
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLinkBooking() {
        return linkBooking;
    }

    public void setLinkBooking(String linkBooking) {
        this.linkBooking = linkBooking;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getQuanlityComment() {
        return quanlityComment;
    }

    public void setQuanlityComment(String quanlityComment) {
        this.quanlityComment = quanlityComment;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getLabel_rate() {
        return label_rate;
    }

    public void setLabel_rate(String label_rate) {
        this.label_rate = label_rate;
    }
    public String getIdHouse() {
        return idHouse;
    }

    public void setIdHouse(String idHouse) {
        this.idHouse = idHouse;
    }
}
