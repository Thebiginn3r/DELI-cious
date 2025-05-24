package com.plurasight;

public abstract class Toppings {
    private String type;
    private int size;

    public Toppings(String type, int size) {
        this.type = type;
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void getPrice(){
    }

}
