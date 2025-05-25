package com.plurasight;

import java.util.List;

public class Chips {
    private List flavor;

    public Chips(List flavor) {
        flavor = flavor;
    }

    public List getFlavor() {
        flavor.add("BBQ");
        flavor.add("Ranch");
        flavor.add("Classic");
        flavor.add("Salt & Vinegar");
        flavor.add("Sour Cream & Onion");
        return flavor;
    }

    public double getPrice(){
        double getPrice = 1.50;
        return getPrice();
    }
}
