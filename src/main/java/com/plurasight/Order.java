package com.plurasight;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Sandwich> sandwiches;
    private List<Drink> drinks;
    private List<Chips> chips;
    private LocalDateTime dateTime;

    public Order() {
        sandwiches = new ArrayList<>();
        drinks = new ArrayList<>();
        chips = new ArrayList<>();
        dateTime = LocalDateTime.now();
    }

    public List getSandwich() {
        return sandwich;
    }

    public List getDrink() {
        return drink;
    }

    public List getChips() {
        return chips;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void getOrderDetails(){

    }

    public void getTotalPrice(){

    }
}
