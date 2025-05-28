package com.plurasight;

public class Cheese extends Toppings{
    public Cheese(String type) {
        super(type);
    }

    @Override
    public double getPrice(int size) {
        switch (size) {
            case 4:
                return 0.75;
            case 8:
                return 1.50;
            case 12:
                return 2.25;
            default:
                return 0.00;
        }
    }
}
