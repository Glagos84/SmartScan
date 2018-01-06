package com.mindweaver.smartscan.models;

import java.io.Serializable;

/**
 * Created by Gabriel on 23-12-2017.
 */

public class Product implements Serializable {

    private String codeBar, formatCodeBar, name, brand, price, place, Uid;


    public Product() {
    }

    public String getCodeBar() {
        return codeBar;
    }

    public void setCodeBar(String codeBar) {
        this.codeBar = codeBar;
    }

    public String getFormatCodeBar() {
        return formatCodeBar;
    }

    public void setFormatCodeBar(String formatCodeBar) {
        this.formatCodeBar = formatCodeBar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getUid() {
        return Uid;
    }

    public void setUid(String uid) {
        this.Uid = uid;
    }
}
