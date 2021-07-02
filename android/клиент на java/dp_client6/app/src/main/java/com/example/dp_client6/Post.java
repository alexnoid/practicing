package com.example.dp_client6;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

public class Post {
    private String name; // название
    private String capital;  // столица
    private  String  flagResource; // ресурс флага

    public Post(String name, String capital, String flag){

        this.name=name;
        this.capital=capital;
        this.flagResource=flag;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return this.capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public  String  getFlagResource() {
        return this.flagResource;
    }

    public void setFlagResource(String  flagResource) {
        this.flagResource = flagResource;
    }
}
