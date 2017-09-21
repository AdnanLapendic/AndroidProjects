package com.dmd.lapa.sarajevograd2;

/**
 * Created by lapa on 9/20/16.
 */

public class Article {

    private int id;
    private String title;
    private String body;
    private String category;
    private String image;
    private String date;
    private String time;


    public Article (int id, String title, String body, String category, String date, String time, String image){
        this.id = id;
        this.title = title;
        this.body = body;
        this.category = category;
        this.date = date;
        this.time = time;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
