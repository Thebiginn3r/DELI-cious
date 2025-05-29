package com.plurasight;

import java.util.List;

public class Chips {
    private String flavor;

    public Chips(String flavor) {
        this.flavor = flavor;
    }

    /*public String getFlavor() {
        flavor.add("BBQ");
        flavor.add("Ranch");
        flavor.add("Classic");
        flavor.add("Salt & Vinegar");
        flavor.add("Sour Cream & Onion");
        return;
    }*/

    public double getPrice(){
        return 1.50;
    }

    @Override
    public String toString() {
        return "Chips " + flavor + " - $" + String.format("%.2f", getPrice());
    }
}
