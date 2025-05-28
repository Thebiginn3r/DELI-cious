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

    public List<Sandwich> getSandwiches(){
        return sandwiches;
    }

    public List<Drink> getDrinks(){
        return drinks;
    }

    public List<Chips> getChips(){
        return chips;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void addSandwich(Sandwich sandwich){
        sandwiches.add(sandwich);
    }

    public void addDrink(Drink drink){
        drinks.add(drink);
    }

    public void addChip(Chips chip){
        chips.add(chip);
    }

    public void getOrderDetails(){

        System.out.println("Order placed on: " + LocalDateTime.now());
        System.out.println();

        double total = 0.00;
        System.out.println("Sandwiches: ");
        int i = 1;
        for (Sandwich s : sandwiches){
            double price = s.calculatePrice();
            System.out.printf(" Sandwich %d - $%.2f", i++, price);
            total += price;
        }

        System.out.println("Drinks:");
        for (Drink d : drinks){
            System.out.println(" " + d);
            total += d.getPrice();
        }

        System.out.println("Chips:");
        for (Chips c : chips){
            System.out.println(" " + c);
            total += c.getPrice();
        }
        System.out.printf("Total Price: $%.2f", total);
    }

    public void getTotalPrice(){

    }


}
