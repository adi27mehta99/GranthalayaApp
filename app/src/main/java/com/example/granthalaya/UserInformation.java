package com.example.granthalaya;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class UserInformation {
private String name;
private String email;
private String Hello;
//private String phone_number;



    public UserInformation() {
    }

    public String getname() {

        return name;

    }

    public String setname(String name) {
        this.name = name;
        return name;
    }

    public String getemail() {
        return email;
    }

    public String setemail(String email) {
        this.email = email;
        return email;
    }

    public String getHello() {
        return Hello;
    }

    public void setHello(String hello) {
        Hello = hello;
    }

    /*public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }*/
}