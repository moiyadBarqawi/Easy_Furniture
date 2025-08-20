package com.example.project.models;

public class Product
{
    String imageurl ;
    String name;
    String description;
    String catagory;
    String price ;
    String quantity;
    String status;
    public Product() {

    }
    public Product(String imageurl, String name, String description, String catagory, String price, String quantity,  String status) {
        this.imageurl = imageurl;
        this.name = name;
        this.description = description;
        this.catagory = catagory;
        this.price = price;
        this.quantity = quantity;
        this.status = status;
    }

    public String getImage() {
        return imageurl;
    }

    public void setImage(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCatagory() {
        return catagory;
    }

    public void setCatagory(String catagory) {
        this.catagory = catagory;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
