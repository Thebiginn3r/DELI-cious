package com.plurasight;

import java.util.List;

public class Drink {
    private List Size;
    private String flavor;

    public Drink(List size, String flavor) {
        Size = size;
        this.flavor = flavor;
    }

    public List getSize() {
        return Size;
    }

    public String getFlavor() {
        return flavor;
    }

    public void getPrice(){

    }


}
