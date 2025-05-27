package com.plurasight;

import java.util.ArrayList;
import java.util.List;

public class Drink {
    private ArrayList<String> size;
    private ArrayList<String> flavor;

    public Drink() {
        size = size;
        flavor = flavor;
    }

    public ArrayList getSize() {
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
    }


}
