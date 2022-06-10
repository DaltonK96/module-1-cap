

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class VendingMachine {
    Map<String, Items> allItems = new HashMap<>();


    public void purchaseItems() {
        String optionsA1 = "A1";
        String optionsA2 = "A2";
        String optionsA3 = "A3";
        String optionsA4 = "A4";
        String optionsB1 = "B1";
        String optionsB2 = "B2";
        String optionsB3 = "B3";
        String optionsB4 = "B4";
        String optionsC1 = "C1";
        String optionsC2 = "C2";
        String optionsC3 = "C3";
        String optionsC4 = "C4";
        String optionsD1 = "D1";
        String optionsD2 = "D2";
        String optionsD3 = "D3";
        String optionsD4 = "D4";

        Scanner purchase = new Scanner(System.in);
        System.out.println("Please enter item selection: ");
        String purchaseInput = purchase.nextLine();
        Wallet money = new Wallet();
        int comparingBalance = allItems.get(purchaseInput).getPrice().compareTo(money.getWallet());
        if (comparingBalance < 0) {


            if (purchaseInput.equals(optionsA1)) {

            } else if (purchaseInput.equals(optionsA2)) {

            } else if (purchaseInput.equals(optionsA3)) {

            } else if (purchaseInput.equals(optionsA4)) {

            } else if (purchaseInput.equals(optionsB1)) {

            } else if (purchaseInput.equals(optionsB2)) {

            } else if (purchaseInput.equals(optionsB3)) {

            } else if (purchaseInput.equals(optionsB4)) {

            } else if (purchaseInput.equals(optionsC1)) {

            } else if (purchaseInput.equals(optionsC2)) {

            } else if (purchaseInput.equals(optionsC3)) {

            } else if (purchaseInput.equals(optionsC4)) {

            } else if (purchaseInput.equals(optionsD1)) {

            } else if (purchaseInput.equals(optionsD2)) {

            } else if (purchaseInput.equals(optionsD3)) {

            } else if (purchaseInput.equals(optionsD4)) {

            } else {
                System.out.println("Invalid Code!");
            }
        }
    }


    public void getItems() throws FileNotFoundException {

        File myFile = new File("C:\\Users\\Student\\workspace\\nlr-8-module-1-capstone-orange-team-4\\vendingmachine.csv");
        try (Scanner vendingFile = new Scanner(myFile)) {


            while (vendingFile.hasNextLine()) {

                String currentLine = vendingFile.nextLine();
                String[] currentItem = currentLine.split("\\|");
                BigDecimal price = new BigDecimal(currentItem[2]);

                Items newItem = new Items(currentItem[1], price, currentItem[0], currentItem[3]);

                allItems.put(currentItem[0], newItem);

            }


        } catch (FileNotFoundException ex) {
            System.out.println("if unable to create file");
        }

        //Items newItems = new Items  (String itemName, BigDecimal price, String slotLocation, String inputType)
    }

    public void displayItems() {
        for (Items value : allItems.values()) {
            if (value.getStock() == 0) {
                System.out.println(value.getSlotLocation() + " " + value.getItemName() + " " + value.getPrice() + " SOLD OUT");
            } else {
                System.out.println(value.getSlotLocation() + " " + value.getItemName() + " " + value.getPrice() + " Stock amount = " + value.getStock());

            }
        }
    }
}