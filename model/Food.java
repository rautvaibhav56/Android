package com.sunbeam.myproject2.model;

public class Food {

    private int id;
    private String food_Type;
    private int  Quantity;
    private int price;
    private String food_Description;
    private String thumbnail;


    public Food(int id, String food_Type, int quantity, int price, String food_Description, String thumbnail) {
        this.id = id;
        this.food_Type = food_Type;
        Quantity = quantity;
        this.price = price;
        this.food_Description = food_Description;
        this.thumbnail = thumbnail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFood_Type() {
        return food_Type;
    }

    public void setFood_Type(String food_Type) {
        this.food_Type = food_Type;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getFood_Description() {
        return food_Description;
    }

    public void setFood_Description(String food_Description) {
        this.food_Description = food_Description;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", food_Type='" + food_Type + '\'' +
                ", Quantity=" + Quantity +
                ", price=" + price +
                ", food_Description='" + food_Description + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                '}';
    }
}
