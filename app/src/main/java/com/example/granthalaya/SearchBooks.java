package com.example.granthalaya;

public class SearchBooks {

    private String title;
    //private String id;

    private String ID;
    private String location;

    public SearchBooks() {
        //empty constructor required
    }

    public SearchBooks(String title, String id, String location) {
        this.title = title;
        this.ID = id;
        this.location=location;

    }

    public String getTitle() {
        return title;
    }

    public String getID() {
        return ID;

    }

    public String getLocation() {
        return location;
    }
}
