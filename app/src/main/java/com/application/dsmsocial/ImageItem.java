package com.application.dsmsocial;

import android.graphics.Bitmap;

public class ImageItem {
    private Bitmap image;
    private String name;
    private String type;
    private String title;
    private String price;

    public ImageItem(Bitmap image, String title, String name, String type, String price) {
        super();
        this.image = image;
        this.name = name;
        this.type = type;
        this.title = title;
        this.price = price;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType(){
        return type;
    }

    public void setType (String type){
        this.type = type;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getPrice() {

        return price;
    }

    public void setPrice(String price)
    {
        this.price = price;
    }





}