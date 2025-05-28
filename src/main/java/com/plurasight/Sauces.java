package com.plurasight;

public class Sauces extends Toppings {
    public Sauces(String type) {
        super(type);
    }

    @Override
    public double getPrice(int size) {
        return 0.00;
    }
}
