package com.plurasight;

import java.util.ArrayList;
import java.util.List;

public class Drink {
    private int size;
    private String flavor;

    public Drink(int size, String flavor) {
        this.size = size;
        this.flavor = flavor;
    }

    public int getSize() {
        return size;
    }

    public String getFlavor() {
        return flavor;
    }



    public double getPrice(){
        switch (size){
            case 1:
                return 2.00;
            case 2:
                return 2.50;
            case 3:
                return 3.00;
            default:
                return 0.00;
        }
    }

    @Override
    public String toString() {
        String saySize = switch (size) {
            case 1 -> "Small";
            case 2 -> "Medium";
            case 3 -> "Large";
            default -> "Unknown Size";
        };
        return saySize + " " + flavor + " - $" + String.format("%.2f", getPrice());
    }

    /* public ArrayList getSize() {
        size.add("Small");
        size.add("Medium");
        size.add("Large");
        return size;
    }

    public List getFlavor() {

        flavor.add("Sprite");
        flavor.add("Coke");
        flavor.add("Orange");
        flavor.add("Lemonade");
        flavor.add("Ice Tea");
        return flavor;
    }

    public double getPrice() {
        double price = 0;
        if (size.equals("Small")) {
            price = 2.00;
        } else if (size.equals("Medium")) {
            price = 2.50;
        } else if (size.equals("Large")) {
            price = 3.00;
        }
        return price;
    }*/


}
