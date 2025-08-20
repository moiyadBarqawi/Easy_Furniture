package com.example.project.models;

public class likedModel {
    int img1, img2;
    String name, price;

    public likedModel(int img1, int img2, String name, String price) {
        this.img1 = img1;
        this.img2 = img2;
        this.name = name;
        this.price = price;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
