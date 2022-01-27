package com.example.granthalaya;

import android.widget.EditText;

public class Books {
   private String title;
   private String description;
   private int priority;

   public Books()
   {
       //Empty Constructor required
   }

   public Books(String title, String description, Integer priority)
   {
       this.title = title;
       this.description = description;
       this.priority= priority;
   }

    public Books(String title, EditText description, int priority) {
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }
}
