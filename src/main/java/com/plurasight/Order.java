package com.plurasight;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private List sandwich;
    private List drink;
    private List chips;
    private LocalDateTime dateTime;

    public Order(List sandwich, List drink, List chips, LocalDateTime dateTime) {
        this.sandwich = sandwich;
        this.drink = drink;
        this.chips = chips;
        this.dateTime = dateTime;
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
