package com.example.granthalaya;

import android.widget.EditText;

public class FavouriteBooks {
    private String title;
    private String description;
    private int rating;

    public FavouriteBooks()
    {
        //Empty Constructor required
    }

    public FavouriteBooks(String title, String description, Integer rating)
    {
        this.title = title;
        this.description = description;
        this.rating= rating;
    }

    public FavouriteBooks(String title, EditText description, int priority) {
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getRating() {
        return rating;
    }
}
