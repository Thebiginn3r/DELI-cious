package com.plurasight;

public abstract class Toppings {
    private String type;


    public Toppings(String type) {
        this.type = type;

    }

    public String getType() {
        return type;
    }

    public void getPrice(){}

    public abstract double getPrice(int size);
}
