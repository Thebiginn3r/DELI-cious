package com.plurasight;

public class Sandwich {
    private boolean toasted;
    private int size;
    private String breadType;
    private boolean isExtraCheese;
    private boolean isExtraMeat;

    public Sandwich(int size, boolean toasted, String breadType, boolean isExtraCheese, boolean isExtraMeat) {
        this.size = size;
        this.toasted = toasted;
        this.breadType = breadType;
        this.isExtraCheese = isExtraCheese;
        this.isExtraMeat = isExtraMeat;
    }

    public boolean isToasted() {
        return toasted;
    }

    public int getSize() {
        return size;
    }

    public String getBreadType() {
        return breadType;
    }

    public boolean isExtraCheese() {
        return isExtraCheese;
    }

    public boolean isExtraMeat(){
        return isExtraMeat;
    }

    public void getPrice(){

    }

    public void getToppings(){

    }
}
