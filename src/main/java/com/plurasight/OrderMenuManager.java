package com.plurasight;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderMenuManager {
    Scanner scanner = new Scanner(System.in);
    private Order currentOrder;
    //List flavor = drink.getFlavor();



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

        //System.out.println(flavor);

    }

    public void startOrder() {
        currentOrder = new Order();
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
        Sandwich sandwich = new Sandwich();
        //add for loop for number of sandwiches later
        System.out.print("What size sandwich would you like? (1) 4 inch, (2) 8 inch, (3) 12 inch: ");
        System.out.println("1) 4 inch");
        System.out.println("2) 8 inch");
        System.out.println("3) 12 inch");
        int sizeChoice = scanner.nextInt();
        // put in a helper method to convert from 123 to 4812
        sandwich.setSize(sizeChoice);
        scanner.nextLine();
        System.out.print("White, Wheat, Rye, Wrap\n What type of bread would you like?: ");
        String breadType = scanner.nextLine();
        sandwich.setBreadType(breadType);
        System.out.println("What meat would you like on your sandwich?\n Steak, Ham, Salami, Roast Beef, Chicken, Bacon");
        // prints out the meat options
        String meatOption = scanner.nextLine();
        sandwich.setMeat(meatOption);
        System.out.println("Would you like extra meat?(yes/no)");
        boolean extraMChoice = scanner.nextBoolean();
        sandwich.setExtraMeat(extraMChoice);
        System.out.println("What cheese would you like?\n American, Provolone, Cheddar, Swiss");
        String cheeseOption = scanner.nextLine();
        sandwich.setCheese(cheeseOption);
        System.out.println("Would you like extra cheese?(yes/no)");
        boolean extraCChoice = scanner.nextBoolean();
        sandwich.setExtraCheese(extraCChoice);

        List<Toppings> toppings = new ArrayList<>();
        System.out.println("How many topping would you like?\n Lettuce, Peppers, Onions, Tomatoes, Jalapenos, Cucumbers, Pickles, Guacamole, Mushrooms");
        int toppingNumber = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < toppingNumber; i++) {
            System.out.print("Pick your topping: ");
            String toppingChoices = scanner.nextLine();
            toppings.add(new RegularTopping(toppingChoices));
        }
        System.out.println("How many sauces would you like?\n Mayo, Mustard, Ketchup, Ranch, Thousand Island, Vinaigrette");
        int sauceNumber = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i <  sauceNumber; i++) {
            System.out.print("Pick your sauce: ");
            String sauceChoices = scanner.nextLine();
            toppings.add(new Sauces(sauceChoices));
        }
        sandwich.setToppings(toppings);

        System.out.println("Sides: Au Jus, Sauce");//print sides
        System.out.println("Would you like a side?(yes/no)");
        String sideChoice = scanner.nextLine();
        sandwich.setSide(sideChoice);
        System.out.println("Would you like the sandwich toasted?(yes/no)");
        String toastedChoice = scanner.nextLine();
        sandwich.setToasted(toastedChoice);


    }

    public void plusDrink(){
        System.out.println("What size drink would you like? 1) Small, 2) Medium, 3) Large");
        int drinkSize = scanner.nextInt();
        System.out.println("What flavor would you like? ");
        String drinkFlavor = scanner.nextLine();
        Drink drink = new Drink(drinkSize, drinkFlavor);
    }

    public void plusChips(){
        System.out.println("What flavor chips would you like?");
        String chipFlavor = scanner.nextLine();

    }

    public void checkout(){
        Order order = new Order();
        System.out.println("Does your order look correct?(yes/no)");
        System.out.println(order);// print out order details
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
