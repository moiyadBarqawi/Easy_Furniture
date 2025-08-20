package com.example.project.models;

public class ItemsModel {

    int img1, img2;
    String price, name;


    public ItemsModel(int img1, int img2, String price, String name) {
        this.img1 = img1;
        this.img2 = img2;
        this.price = price;
        this.name = name;
    }

    public int getImg1() {
        return img1;
    }

    public void setImg1(int img1) {
        this.img1 = img1;
    }

    public int getImg2() {
        return img2;
    }

    public void setImg2(int img2) {
        this.img2 = img2;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
