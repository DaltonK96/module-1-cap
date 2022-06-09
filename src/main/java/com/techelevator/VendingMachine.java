package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Scanner;

public class VendingMachine {
    public VendingMachine() throws FileNotFoundException {

    File myFile = new File("C:\\Users\\Student\\workspace\\nlr-8-module-1-capstone-orange-team-4\\vendingmachine.csv");
    try(Scanner vendingFile = new Scanner(myFile)) {

        while (vendingFile.hasNextLine()) {
            String currentLine = vendingFile.nextLine();
        }


    } catch(FileNotFoundException ex) {
        System.out.println("if unable to create file");
    }






    //Items newItems = new Items  (String itemName, BigDecimal price, String slotLocation, String inputType)
} }
