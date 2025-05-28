package com.plurasight;

import java.util.ArrayList;
import java.util.List;

public class Drink {
    private String size;
    private String flavor;

    public Drink(String size, String flavor) {
        this.size = size;
        this.flavor = flavor;
    }

    public String getSize() {
        return size;
    }

    public String getFlavor() {
        return flavor;
    }

    public double getPrice(){
        switch (size.toLowerCase()){
            case "small":
                return 2.00;
            case "medium":
                return 2.50;
            case "large":
                return 3.00;
            default:
                return 0.00;
        }
    }

    @Override
    public String toString() {
        return size + " " + flavor + " - $" + getPrice();
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
