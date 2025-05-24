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
