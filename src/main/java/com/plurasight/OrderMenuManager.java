package com.plurasight;

import java.util.Scanner;

public class OrderMenuManager {
    Scanner scanner = new Scanner(System.in);
    private Order order;


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

    }

    public void startOrder(){
        System.out.print("Would you like a sandwich?(yes/no): ");
        String sandChoice = scanner.nextLine();
        scanner.nextLine();
        System.out.print("Would you like a drink?(yes/no): ");
        String drinkChoice = scanner.nextLine();
        //scanner.nextLine();
        System.out.print("Would you like chips?(yes/no): ");
        String chipChoice = scanner.nextLine();
        System.out.println();

        if (sandChoice.equalsIgnoreCase("yes")) {
            plusSandwich();
        } else {
            return;
        }
        if (drinkChoice.equalsIgnoreCase("yes")){
            plusDrink();
        }
        if (chipChoice.equalsIgnoreCase("yes")){
            plusChips();
        }

    }

    public void seeReceipt(){

    }

    public void plusSandwich(){
        System.out.print("What size sandwich would you like? (1 - 4 inch, 2 - 8 inch, 3 - 12 inch): ");

    }

    public void plusDrink(){

    }

    public void plusChips(){

    }

}
