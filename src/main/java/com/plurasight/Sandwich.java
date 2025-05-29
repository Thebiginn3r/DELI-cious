package com.plurasight;

import java.util.ArrayList;
import java.util.List;

public class Sandwich {
    private String toasted;
    private int size;
    private String breadType;
    private String meat;
    private String cheese;
    private boolean extraCheese;
    private boolean extraMeat;
    private List<String> sides = new ArrayList<>();
    private List<Toppings> toppings;

    public Sandwich() {
        this.toasted = toasted;
        this.size = size;
        this.breadType = breadType;
        this.extraCheese = extraCheese;
        this.extraMeat = extraMeat;
        this.toppings = toppings;
        this.meat = meat;
        this.cheese = cheese;
        this.sides = sides;
    }

    public String side() {
        return sides;
    }

    public void setSide(String side) {
        this.sides = side;
    }

    public boolean getExtraMeat() {
        return extraMeat;
    }

    public boolean getExtraCheese() {
        return extraCheese;
    }

    public void setToasted(String toasted) {
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
        this.extraCheese = extraCheese;
    }

    public void setExtraMeat(boolean extraMeat) {
        this.extraMeat = extraMeat;
    }

    public void setToppings(List<Toppings> toppings) {
        this.toppings = toppings;
    }

    public String toasted() {
        return toasted;
    }

    public int getSize() {
        return size;
    }

    public String getBreadType() {
        return breadType;
    }



    public void getPrice(){

    }

    public void getToppings(){

    }

    public void addside(String side){
        sides.
    }

    public double calculatePrice(){
        double baseSandwich = switch (size){
            case 4 -> 5.50;
            case 8 -> 7.00;
            case 12 -> 8.50;
            default -> 0.0;
        };

        double extras = 0.0;
        if (extraMeat) extras += switch (size) {
            case 4 -> .50;
            case 8 -> 1.00;
            case 12 -> 1.50;
            default -> 0.0;
        };
        if (extraCheese) extras += switch (size) {
            case 4 -> .30;
            case 8 -> .60;
            case 12 -> .90;
            default -> 0.00;
        };

        for (Toppings t : toppings) {
            extras += t.getPrice(size);
        }

        return baseSandwich + extras;
    }
}
