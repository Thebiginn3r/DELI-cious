package com.plurasight;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderMenuManager {
    Scanner scanner = new Scanner(System.in);
    private Order currentOrder;
    //List flavor = drink.getFlavor();
    boolean quit = false;



    public void display(){

        while(!quit){
            System.out.println("Welcome to your favorite Deli shop. Pick an option to continue");
            System.out.println("1 - Start Order");
            System.out.println("2 - See Receipt");//preview of receipt
            System.out.println("3 - See Prices");
            System.out.println("4 - Exit");


            System.out.print("Option choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

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
                    quit = true;
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
            System.out.println();
            System.out.println("1 - Add sandwich");
            System.out.println("2 - Add drink");
            System.out.println("3 - Add chips");
            System.out.println("4 - Checkout");
            System.out.println("5 - Cancel Order");
            System.out.print("Option choice: ");
            //scanner.nextLine();

            String input = scanner.nextLine().trim();

            switch (input) {
                case "1":
                    Sandwich newSandwich = plusSandwich();
                    currentOrder.addSandwich(newSandwich);
                    break;
                case "2":
                    plusDrink();
                    break;
                case "3":
                    plusChips();
                    break;
                case "4":
                    checkout();
                    break;
                case "5":
                    cancelOrder();
                    running = false;
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }

        }
    }

    public void seeReceipt(){

    }

    public Sandwich plusSandwich(){
        Sandwich sandwich = new Sandwich();
        System.out.println("What size sandwich would you like? (1) 4 inch, (2) 8 inch, (3) 12 inch: ");
        int sizeChoice = scanner.nextInt();
        int actualSize;
        switch (sizeChoice) {
            case 1:
                actualSize = 4;
                break;
            case 2:
                actualSize = 8;
                break;
            case 3:
                actualSize = 12;
                break;
            default:
                System.out.println("Invalid choice. Defaulting to 8 inch sandwich.");
                actualSize = 8;
        }
        sandwich.setSize(actualSize);
        scanner.nextLine();

        String breadType = breadTypeConversion();
        sandwich.setBreadType(breadType);

        String meatType = meatTypeConversion();
        sandwich.setMeat(meatType);
        scanner.nextLine();

        System.out.println("Would you like extra meat?(yes/no)");
        String inputM = scanner.nextLine().trim().toLowerCase();
        boolean extraMChoice = inputM.equals("yes");
        sandwich.setExtraMeat(extraMChoice);

        String cheeseType = cheeseTypeConversion();
        sandwich.setCheese(cheeseType);
        scanner.nextLine();

        System.out.println("Would you like extra cheese?(yes/no)");
        String inputC = scanner.nextLine().trim().toLowerCase();
        boolean extraCChoice = inputC.equals("yes");
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

        System.out.println("Sides: Au Jus, Sauce\nHow many sides would you like?");
        int sideNumber = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i <  sideNumber; i++) {
            System.out.print("Pick your sauce: ");
            String sideChoice = scanner.nextLine();
            sandwich.addside(sideChoice);
        }

        System.out.println("Would you like the sandwich toasted?(yes/no)");
        String toastedChoice = scanner.nextLine();
        sandwich.setToasted(toastedChoice);
        return sandwich;

    }

    public void plusDrink(){
        System.out.println("What size drink would you like? 1) Small, 2) Medium, 3) Large");
        int drinkSize = scanner.nextInt();
        scanner.nextLine();
        System.out.println("What flavor would you like?\nSprite, Ice Tea, Orange Soda, Coke, Milk");
        System.out.print("Flavor choice: ");
        String drinkFlavor = scanner.nextLine();
        Drink drink = new Drink(drinkSize, drinkFlavor);
        currentOrder.addDrink(drink);
    }

    public void plusChips(){
        System.out.println("What flavor chips would you like?\nBBQ, Ranch, Classic, Salt and Vinegar, Sour Cream and onion");
        System.out.print("Flavor choice: ");
        String chipFlavor = scanner.nextLine();
        Chips chips = new Chips(chipFlavor);
        currentOrder.addChip(chips);
    }

    public void checkout(){
        if (currentOrder == null){
            System.out.println("You haven't added any items to your order yet");
            return;
        }
        currentOrder.getOrderDetails();

        System.out.println("Does your order look correct?(yes/no)");
        String orderCheck = scanner.nextLine();
        if (orderCheck.equalsIgnoreCase("yes")){
            //write to receipt file
            System.out.println("Thanx your order has been placed");
        } else if (orderCheck.equalsIgnoreCase("no")) {
            editOrder();
        } else {
            System.out.println("Invalid choice. Returning to menu");
        }

        ReceiptWriter rw = new ReceiptWriter(currentOrder);
        rw.saveOrder();
    }

    public void cancelOrder(){

    }


    public void editOrder(){
        System.out.println("What would you like to change?");
        String changeCheck = scanner.nextLine();
    }

    public String breadTypeConversion(){
        System.out.print("1) White\n2) Wheat\n3) Rye\n4) Wrap\nWhat type of bread would you like?: ");
        int breadChoice = scanner.nextInt();
        String breadType;
        switch (breadChoice) {
            case 1:
                return "White";
            case 2:
                return "Wheat";
            case 3:
                return "Rye";
            case 4:
                return "Wrap";
            default:
                System.out.println("Invalid choice. Defaulting to White bread for our illiterate user");
                return "White";
        }
    }

    public String meatTypeConversion(){
        System.out.print("\n1) Steak\n2) Ham\n3) Salami\n4) Roast Beef\n5) Buffalo Chicken\n6) Bacon\nWhat meat would you like on your sandwich: ");
        int meatChoice = scanner.nextInt();
        String breadType;
        switch (meatChoice) {
            case 1:
                return "Steak";
            case 2:
                return "Ham";
            case 3:
                return "Salami";
            case 4:
                return "Roast Beef";
            case 5:
                return "Buffalo Chicken";
            case 6:
                return "Bacon";
            default:
                System.out.println("Invalid choice. Defaulting to Ham for someone who doesn't listen");
                return "Ham";
        }
    }

    public String cheeseTypeConversion(){
        System.out.println("1) American\n2) Provolone\n3) Cheddar\n4) Swiss\nWhat cheese would you like: ");
        int cheeseChoice = scanner.nextInt();
        String cheeseType;
        switch (cheeseChoice) {
            case 1:
                return "American";
            case 2:
                return "Provolone";
            case 3:
                return "Cheddar";
            case 4:
                return "Swiss";
            default:
                System.out.println("Invalid choice. Defaulting to Cheddar for our pet peeve of a customer");
                return "Cheddar";
        }
    }
}
