package com.example.androiappm.Domain;

import java.io.Serializable;

public class MakeupDomain implements Serializable {
    private String title;
    private String pic;
    private String description;
    private int fee;
    private int reviews;
    private int star;
    private int time;
    private int numberInCart;

    public MakeupDomain(String title, String pic, String description, int fee, int star, int time, int reviews) {
        this.title = title;
        this.pic = pic;
        this.description = description;
        this.fee = fee;
        this.star = star;
        this.time = time;
        this.reviews = reviews;
    }

    public int getNumberInCart() {
        return numberInCart;
    }

    public void setNumberInCart(int numberInCart) {
        this.numberInCart = numberInCart;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getReviews() {
        return reviews;
    }

    public void setReviews(int calories) {
        this.reviews = calories;
    }
}
