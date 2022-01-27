package com.example.granthalaya;

import android.widget.EditText;

public class IssuedBooks {

    private String title;
    private String issued_date;
    //private String description;
   // private int priority;
    private String return_date;

    public IssuedBooks()
    {
        //Empty Constructor required
    }

    public IssuedBooks(String title, String issued_date, String return_date)
    {
        this.title = title;
        this.issued_date = issued_date;
        this.return_date= return_date;
    }

    public IssuedBooks(String title, EditText description, int priority) {
    }

    public String getTitle() {
        return title;
    }

    public String getIssued_date() {
        return issued_date;
    }

    public String getReturn_date() {
        return return_date;
    }
}
