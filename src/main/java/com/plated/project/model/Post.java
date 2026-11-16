package com.plated.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Post {

    private Long id;
    private String restaurant;
    private String dish;
    private int likes;
    private boolean liked;
    private String location;
    private String note;
    private long rate;
    private String imgUrl;
    private long ticketNo;
    // TODO: replace loggedByName/loggedByAvatarUrl with a real User relation once auth is wired in.
    private String loggedByName;
    private String loggedByAvatarUrl;
    private String date;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }

    public String getDish() {
        return dish;
    }

    public void setDish(String dish) {
        this.dish = dish;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public boolean isLiked() {
        return liked;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public long getRate() {
        return rate;
    }

    public void setRate(long rate) {
        this.rate = rate;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public long getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(long ticketNo) {
        this.ticketNo = ticketNo;
    }

    public String getLoggedByName() {
        return loggedByName;
    }

    public void setLoggedByName(String loggedByName) {
        this.loggedByName = loggedByName;
    }

    public String getLoggedByAvatarUrl() {
        return loggedByAvatarUrl;
    }

    public void setLoggedByAvatarUrl(String loggedByAvatarUrl) {
        this.loggedByAvatarUrl = loggedByAvatarUrl;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
