package com.plurasight;

//mport jdk.internal.icu.impl.NormalizerImpl;

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
            System.out.println("2 - See Prices");
            System.out.println("3 - Exit");


            System.out.print("Option choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1:
                    startOrder();
                    break;
                case 2:
                    seePrices();
                    break;
                case 3:
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

    }

    public void startOrder() {
        currentOrder = new Order();
        boolean running = true;
        while (running) {
            System.out.println();
            System.out.println("1 - Add sandwich");
            System.out.println("2 - Add drink");
            System.out.println("3 - Add chips");
            System.out.println("4 - Preview Order");
            System.out.println("5 - Checkout");
            System.out.println("6 - Cancel Order");
            System.out.print("Option choice: ");

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
                    previewOrder();
                    break;
                case "5":
                    boolean isFinished = checkout();
                    if (isFinished){
                        running = false;
                    }
                    break;
                case "6":
                    boolean isGone = cancelOrder();
                    if (isGone) {
                        running = false;
                    }
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }

        }
    }

    public void previewOrder(){
        if (currentOrder == null){
            System.out.println("Nothing in the order");
            return;
        }
        currentOrder.getOrderDetails();

    }

    public Sandwich plusSandwich(){
        Sandwich sandwich = new Sandwich();
        System.out.println();
        System.out.println("1) 4 inch\n2) 8 inch\n3) 12 inch\nWhat size sandwich would you like: ");
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
                System.out.print("Invalid choice. Defaulting to 8 inch sandwich.");
                actualSize = 8;
        }
        sandwich.setSize(actualSize);
        scanner.nextLine();

        String breadType = breadTypeConversion();
        sandwich.setBreadType(breadType);

        String meatType = meatTypeConversion();
        sandwich.setMeat(meatType);
        scanner.nextLine();

        System.out.println();
        System.out.print("Would you like extra meat(yes/no): ");
        String inputM = scanner.nextLine().trim().toLowerCase();
        boolean extraMChoice = inputM.equals("yes");
        sandwich.setExtraMeat(extraMChoice);
        System.out.println();

        String cheeseType = cheeseTypeConversion();
        sandwich.setCheese(cheeseType);
        scanner.nextLine();

        System.out.println();
        System.out.print("Would you like extra cheese(yes/no): ");
        String inputC = scanner.nextLine().trim().toLowerCase();
        boolean extraCChoice = inputC.equals("yes");
        sandwich.setExtraCheese(extraCChoice);
        System.out.println();

        List<Toppings> toppings = toppingsConversion();
        sandwich.setToppings(toppings);

        List<Toppings> sauces = saucesConversion();
        sandwich.setToppings(sauces);

        List<String> sides = sideConversion();
        for (String side : sides) {
            sandwich.addside(side);
        }

        System.out.println();
        System.out.print("Would you like the sandwich toasted(yes/no): ");
        String toastedChoice = scanner.nextLine();
        sandwich.setToasted(toastedChoice);
        return sandwich;
    }

    public void plusDrink(){
        System.out.println();
        System.out.println("1) Small\n2) Medium\n3) Large\nWhat size drink would you like? ");
        int drinkSize = scanner.nextInt();
        scanner.nextLine();
        String drinkFlavor = drinkFlavorConversion();
        Drink drink = new Drink(drinkSize, drinkFlavor);
        currentOrder.addDrink(drink);
    }

    public void plusChips(){
       String chipFlavor = chipFlavorConversion();
        Chips chips = new Chips(chipFlavor);
        currentOrder.addChip(chips);
    }

    public boolean checkout(){
        currentOrder.getOrderDetails();

        System.out.println("Does your order look correct?(yes/no)");
        String orderCheck = scanner.nextLine().trim().toLowerCase();

        if (orderCheck.equalsIgnoreCase("yes")){
            ReceiptWriter rw = new ReceiptWriter(currentOrder);
            rw.saveOrder();
            System.out.println("Thanx your order has been placed");
            return true;
        } else if (orderCheck.equals("no")){
            System.out.println("You can keep adding to your order");
            return false;
        } else {
            System.out.println("Invalid input returning to main menu");
            return false;
        }

        /*ReceiptWriter rw = new ReceiptWriter(currentOrder);
        rw.saveOrder();*/

    }

    public boolean cancelOrder(){
        if (currentOrder == null ||(currentOrder.getSandwiches().isEmpty() && currentOrder.getDrinks().isEmpty() && currentOrder.getChips().isEmpty())){
            System.out.println("\nThere is no order yet");
            System.out.println("Returning to the menu...");
            return false;
        }
        currentOrder.getOrderDetails();
        System.out.println("Are you sure you want to cancel your order(yes/no): ");
        String cancelChoice = scanner.nextLine();

        if (cancelChoice.equalsIgnoreCase("yes")){
            currentOrder = null;
            System.out.println("Your current order has been deleted");
            return true;
        } else if (cancelChoice.equals("no")){
            System.out.println("Returning you back to the menu");
            return false;
        } else {
            System.out.println("Since your unsure or just can't spell I'll send you back to the menu.");
            return false;
        }

    }
    /*public void editOrder(){
        System.out.println("What would you like to change?");
        String changeCheck = scanner.nextLine();
    }*/

    public String breadTypeConversion(){
        System.out.print("\n1) White\n2) Wheat\n3) Rye\n4) Wrap\nWhat type of bread would you like?: ");
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
        String meatType;
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

    public List<Toppings> toppingsConversion() {
        List<Toppings> toppings = new ArrayList<>();

        String[] toppingOptions = {
                "Lettuce", "Peppers", "Onions", "Tomatoes", "Jalapenos",
                "Cucumbers", "Pickles", "Guacamole", "Mushrooms"
        };

        System.out.println("Available Toppings:");
        for (int i = 0; i < toppingOptions.length; i++) {
            System.out.println((i + 1) + ") " + toppingOptions[i]);
        }

        System.out.print("How many toppings would you like: ");
        int toppingNumber = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < toppingNumber; i++) {
            System.out.print("Pick your topping (1–9): ");
            int toppingChoice = scanner.nextInt();
            scanner.nextLine();

            if (toppingChoice >= 1 && toppingChoice <= toppingOptions.length) {
                String toppingName = toppingOptions[toppingChoice - 1];
                toppings.add(new RegularTopping(toppingName));
            } else {
                System.out.println("Invalid choice. Adding default topping: Jalapenos.");
                toppings.add(new RegularTopping("Jalapenos"));
            }
        }

        return toppings;
    }

    public List<Toppings> saucesConversion() {
        List<Toppings> toppings = new ArrayList<>();

        String[] sauceOptions = {
                "Mayo", "Mustard", "Null", "Ketchup", "Ranch",
                "Thousand Island", "Vinaigrette"
        };

        System.out.println("Available Sauces:");
        for (int i = 0; i < sauceOptions.length; i++) {
            if (!sauceOptions[i].equals("Null")) {
                System.out.println((i + 1) + ") " + sauceOptions[i]);
            }
        }

        System.out.print("How many sauces would you like: ");
        int sauceNumber = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < sauceNumber; i++) {
            System.out.print("Pick your sauce (1-" + sauceOptions.length + "): ");
            int sauceChoice = scanner.nextInt();
            scanner.nextLine();

            if (sauceChoice >= 1 && sauceChoice <= sauceOptions.length) {
                String sauceName = sauceOptions[sauceChoice - 1];
                toppings.add(new Sauces(sauceName));
            } else {
                System.out.println("Invalid choice. Adding default sauce: Ketchup.");
                toppings.add(new Sauces("Ketchup"));
            }
        }

        return toppings;
    }

    public List<String> sideConversion() {
        List<String> selectedSides = new ArrayList<>();

        System.out.println("Sides Available:");
        System.out.println("1) Au Jus");
        System.out.println("2) Sauce");
        System.out.print("How many sides would you like? ");
        int sideNumber = scanner.nextInt();
        scanner.nextLine();

        if (sideNumber == 2) {
            selectedSides.add("Au Jus");
            selectedSides.add("Sauce");
        } else if (sideNumber == 1) {
            System.out.print("Pick a side (1 for Au Jus, 2 for Sauce): ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                selectedSides.add("Au Jus");
            } else if (choice == 2) {
                selectedSides.add("Sauce");
            } else {
                System.out.println("Invalid input. Defaulting to Sauce.");
                selectedSides.add("Sauce");
            }
        } else {
            System.out.println("Invalid input. No sides added.");
        }

        return selectedSides;
    }

    public String drinkFlavorConversion(){
        System.out.println();
        String[] flavors = {"Sprite", "Ice Tea","Orange Soda", "Coke", "Water"};
        System.out.println("1) Sprite\n2) Ice Tea\n3) Orange Soda\n4) Coke\n5) Water\nWhat flavor would you like?");
        System.out.print("Flavor choice (1-5): ");
        int flavorChoice = scanner.nextInt();
        scanner.nextLine();

        String drinkFlavor;
        if(flavorChoice >= 1 && flavorChoice <= flavors.length){
            drinkFlavor = flavors[flavorChoice - 1];
        } else {
            System.out.println("Invalid choice. Your just getting a Sprite pal");
            drinkFlavor = "Sprite";
        }
        return drinkFlavor;
    }

    public String chipFlavorConversion (){
        System.out.println();
        String[] flavors = {"BBQ", "Ranch","Classic", "Salt and Vinegar", "Sour Cream and Onion"};
        System.out.println("1) BBQ\n2) Ranch\n3) Classic\n4) Salt and Vinegar\n5) Sour Cream and Onion\nWhat flavor would you like?");
        System.out.print("Flavor choice (1-5): ");
        int flavorChoice = scanner.nextInt();
        scanner.nextLine();
        String chipFlavor;
        if(flavorChoice >= 1 && flavorChoice <= flavors.length){
            chipFlavor = flavors[flavorChoice - 1];
        } else {
            System.out.println("Invalid choice. You just getting BBQ kid");
            chipFlavor = "BBQ";
        }
        return chipFlavor;
    }
}
