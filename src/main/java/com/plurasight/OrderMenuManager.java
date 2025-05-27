package com.plurasight;

import java.util.List;
import java.util.Scanner;

public class OrderMenuManager {
    Scanner scanner = new Scanner(System.in);
    private Order order;
    Drink drink = new Drink();
    List flavor = drink.getFlavor();


    public void display(){
        boolean quit = false;
        while(!quit){
            System.out.println("Welcome to your favorite Deli shop. Pick an option to continue");
            System.out.println("1 - Start Order");
            System.out.println("2 - See Receipt");//preview of receipt
            System.out.println("3 - See Prices");
            System.out.println("4 - Exit");

            System.out.print("Option choice: ");
            int choice = scanner.nextInt();

            switch (choice){
                case 1:
                    startOrder();
                    break;
                case 2:
                    seeReceipt();
                    break;
                case 3:
                    seePrices();
                    break;
                case 4:
                    System.out.println("Have a nice day");
                    quit = false;
                    break;
                default:
                    System.out.println("Invalid choice pick again");
            }
        }

    }

    public void seePrices(){
        System.out.printf("%-12s %-12s %-12s %-12s%n %-14s %-12s %-12s %-12s%n", "Sandwich prices", "4 inch", "8 inch", "12 inch", "", "$5.50", "$7.00", "$8.50");
        System.out.println("                ----------------------------------------");
        System.out.printf("%-15s %-12s %-12s %-12s%n", "Meat Toppings", "$1.00", "$2.00", "$3.00");
        System.out.println("               ----------------------------------------");
        System.out.printf("%-15s %-12s %-12s %-12s%n", "Extra Meat", "$.50", "$1.00", "$1.50");
        System.out.println("               ----------------------------------------");
        System.out.printf("%-15s %-12s %-12s %-12s%n", "Cheese", "$.75", "$1.50", "$2.25");
        System.out.println("               ----------------------------------------");
        System.out.printf("%-15s %-12s %-12s %-12s%n", "Extra Cheese", "$.30", "$.60", "$.90");
        System.out.println("               ----------------------------------------");
        System.out.printf("%-15s %-12s%n", "Regular Toppings", "Included");
        System.out.println("                ----------------------------------------");
        System.out.printf("%-15s %-12s%n", "Sauces", "Included");
        System.out.println("                ----------------------------------------");
        System.out.printf("%-15s %-12s%n", "Sides", "Included");
        System.out.println("                ----------------------------------------");
        System.out.printf("%-15s %-12s %-12s %-12s%n", "Other Products", "Small", "Medium", "Large");
        System.out.println("               ----------------------------------------");
        System.out.printf("%-15s %-12s %-12s %-12s%n", "Drinks", "$2.00", "$2.50", "$3.00");
        System.out.println("               ----------------------------------------");
        System.out.printf("%-15s %-12s%n", "All Chips", "$1.50");

        System.out.println();

    }

    public void startOrder() {
        boolean running = true;
        while (running) {
            System.out.println("1 - Add sandwich");
            System.out.println("2 - Add drink");
            System.out.println("3 - Add chips");
            System.out.println("4 - Checkout");
            System.out.println("5 - Cancel Order");
            scanner.nextLine();

            String input = scanner.nextLine().trim();

            switch (input) {
                case "1":
                    plusSandwich();
                    break;
                case "2":
                    plusDrink();
                    break;
                case "3":
                    plusChips();
                case "4":
                    checkout();
                    break;
                case "5":
                    cancelOrder();
                    running = false;
                default:
                    System.out.println("Invalid input");
                    break;
            }

        }
    }

    public void seeReceipt(){

    }

    public void plusSandwich(){
        System.out.print("What type of bread would you like?");
        System.out.println();//prints out the bread type arraylist
        String breadType = scanner.nextLine();
        //System.out.println("What size sandwich would you like?");
        System.out.print("What size sandwich would you like? (1) 4 inch, (2) 8 inch, (3) 12 inch: ");
        System.out.println("1) 4 inch");
        System.out.println("2) 8 inch");
        System.out.println("3) 12 inch");
        int sizeChoice = scanner.nextInt();
        scanner.nextLine();
        System.out.println("What meat would you like on your sandwich?");
        System.out.println();// prints out the meat options
        String meatOption = scanner.nextLine();
        System.out.println("Would you like extra meat?(yes/no)");
        String extraMChoice = scanner.nextLine();
        System.out.println("What cheese would you like?");
        System.out.println();//prints out the cheese options
        String cheeseOption = scanner.nextLine();
        System.out.println("Would you like extra cheese?(yes/no)");
        String extraCChoice = scanner.nextLine();
        System.out.println();// show topping options
        System.out.println("How many topping would you like?");
        int toppingNumber = scanner.nextInt();
        for (int i = 0; i < toppingNumber; i++) {
            System.out.print("Pick your topping: ");
            String toppingChoices = scanner.nextLine();
        }
        System.out.println("How many sauces would you like?");
        int sauceNumber = scanner.nextInt();
        for (int i = 0; i < toppingNumber; i++) {
            System.out.print("Pick your sauce: ");
            String sauceChoices = scanner.nextLine();
        }
        System.out.println();//print sides
        System.out.println("Would you like a side?(yes/no)");
        String sideChoice = scanner.nextLine();
        System.out.println("Would you like the sandwich toasted?(yes/no)");
        boolean toastedChoice = scanner.hasNextLine();
    }

    public void plusDrink(){
        System.out.println("What size drink would you like? 1) Small, 2) Medium, 3) Large");
        int drinkSize = scanner.nextInt();
        System.out.println("What flavor would you like? ");
        String drinkFlavor = scanner.nextLine();

    }

    public void plusChips(){
        System.out.println("What flavor chips would you like?");
        String chipFlavor = scanner.nextLine();

    }

    public void checkout(){
        System.out.println("Does your order look correct?(yes/no)");
        System.out.println();// print out order details
        String orderCheck = scanner.nextLine();
        if (orderCheck.equalsIgnoreCase("yes")){
            //write to receipt file
            return;
        } if (orderCheck.equalsIgnoreCase("no")) {
            editOrder();
        } else {
            System.out.println("Invalid choice. Try again.");
            return;
        }


    }

    public void cancelOrder(){

    }

    public void editOrder(){}

}
