package com.example.project.models;

public class ModelCart {
    String itemname;
    String itemprice;
    int itemimage;
    int itemquantity;

    public ModelCart(String itemname, String itemprice, int itemimage, int itemquantity) {
        this.itemname = itemname;
        this.itemprice = itemprice;
        this.itemimage = itemimage;
        this.itemquantity = itemquantity;
    }

    public String getItemname() {
        return itemname;
    }

    public String getItemprice() {
        return itemprice;
    }

    public int getItemimage() {
        return itemimage;
    }

    public int getItemquantity() {
        return itemquantity;
    }
}
