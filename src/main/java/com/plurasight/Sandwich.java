package com.plurasight;

import java.util.List;

public class Sandwich {
    private boolean toasted;
    private int size;
    private String breadType;
    private String meat;
    private String cheese;
    private boolean isExtraCheese;
    private boolean isExtraMeat;
    private List<Toppings> toppings;

    public Sandwich() {
        this.toasted = toasted;
        this.size = size;
        this.breadType = breadType;
        this.isExtraCheese = isExtraCheese;
        this.isExtraMeat = isExtraMeat;
        this.toppings = toppings;
        this.meat = meat;
        this.cheese = cheese;
    }

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }

    public String getCheese() {
        return cheese;
    }

    public void setCheese(String cheese) {
        this.cheese = cheese;
    }

    public String getMeat() {
        return meat;
    }

    public void setMeat(String meat) {
        this.meat = meat;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setBreadType(String breadType) {
        this.breadType = breadType;
    }

    public void setExtraCheese(boolean extraCheese) {
        isExtraCheese = extraCheese;
    }

    public void setExtraMeat(boolean extraMeat) {
        isExtraMeat = extraMeat;
    }

    public void setToppings(List<Toppings> toppings) {
        this.toppings = toppings;
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
