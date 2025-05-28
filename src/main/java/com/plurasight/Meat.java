package com.plurasight;

public class Meat extends Toppings{
    public Meat(String type) {
        super(type);
    }

    @Override
    public double getPrice(int size) {
        switch (size) {
            case 4:
                return 1.00;
            case 8:
                return 2.00;
            case 12:
                return 3.00;
            default:
                return 0.00;
        }
    }
}
