package com.plurasight;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptWriter {
    private static final String Receipt_Folder = "receipts";
    private final Order order;

    public ReceiptWriter(Order order) {
        this.order = order;
    }

    public void saveOrder(){
        DateTimeFormatter fileformatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        String fileName = "receipt_" + order.getDateTime().format(fileformatter) + ".txt";

        File folder = new File(Receipt_Folder);
        if (!folder.exists()){
            folder.mkdir();
        }

        File recieptFile = new File(folder,fileName);

        try (PrintWriter pw = new PrintWriter(new FileWriter(recieptFile))) {
            pw.write(getOrderDetailsAsString());
            System.out.println("Order saved successfully to " + recieptFile.getPath());
        } catch (IOException e) {
            System.out.println("Failed to write receipt: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private String getOrderDetailsAsString(){

        StringBuilder sb = new StringBuilder();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd|HH:mm:ss");
        sb.append("Order placed on: ").append(LocalDateTime.now().format(formatter)).append("\n");

        double total = 0.0;
        int i = 1;

        sb.append("Sandwiches:\n");
        for (Sandwich s : order.getSandwiches()){
            double price = s.calculatePrice();
            sb.append(" Sandwich ").append(i++).append(" - $").append(String.format("%.2f", price)).append("\n");
            total += price;
        }

        sb.append("Drinks:\n");
        for (Drink d : order.getDrinks()){
            sb.append(" ").append(d.toString()).append("\n");
            total += d.getPrice();
        }

        sb.append("Chips:\n");
        for (Chips c : order.getChips()){
            sb.append(" ").append(c.toString()).append("\n");
            total += c.getPrice();
        }

        sb.append("Total Price: $").append(String.format("%.2f", total)).append("\n");
        sb.append("--------------------------------------------------\n\n");

        return sb.toString();
    }
}
