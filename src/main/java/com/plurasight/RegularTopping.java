package com.plurasight;

public class RegularTopping extends Toppings{
    public RegularTopping(String type) {
        super(type);
    }

    @Override
    public double getPrice(int size) {
        return 0.00;
    }
}
