package com.plurasight;

import java.util.List;

public class Drink {
    private List size;
    private List flavor;

    public Drink(List size, List flavor) {
        size = size;
        flavor = flavor;
    }

    public List getSize() {
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
