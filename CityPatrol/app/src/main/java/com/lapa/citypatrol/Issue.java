package com.lapa.citypatrol;

/**
 * Created by lapa on 10/21/16.
 */

public class Issue {

    private int id;
    private String category;
    private String imageUrl;
    private String latitude;
    private String longitude;
    private String description;
    private String address;

    public Issue(){

    }

    public Issue(String category, String imageUrl, String latitude, String longitude, String description, String address) {
        this.category = category;
        this.imageUrl = imageUrl;
        this.latitude = latitude;
        this.description = description;
        this.longitude = longitude;
        this.address = address;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
