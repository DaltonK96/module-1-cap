

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class VendingMachine {
    Map<String, Items> allItems = new HashMap<>();


    public void purchaseItems(Wallet money) {
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

        String crunch = "Crunch Crunch, Crunch!";
        String munch = "Munch Munch, Mmm-Good!";
        String cheersGlug = "Cheers Glug, Glug!";
        String chewPop = "Chew Chew, Pop!";


        Scanner purchase = new Scanner(System.in);
        System.out.println("Please enter item selection: ");
        String purchaseInput = purchase.nextLine();

        Items currentItem = allItems.get(purchaseInput);
        BigDecimal price = currentItem.getPrice();
        int comparingBalance = price.compareTo(money.getWallet());

        String slogan = "";
        if (currentItem.getInputType().equals("Chip"))
        {
            slogan = crunch;
        } else if (currentItem.getInputType().equals("Candy"))
        {
            slogan = munch;
        } else if (currentItem.getInputType().equals("Drink"))
        {
            slogan = cheersGlug;
        } else if(currentItem.getInputType().equals("Gum"))
        {
            slogan = chewPop;
        }
        if (comparingBalance < 0) {


            if (purchaseInput.equals(optionsA1)) {
                currentItem.stockRemove();
                money.payment(price);

                System.out.println(currentItem.getItemName() + " " + price + " " + money.getWallet());
                System.out.println(slogan);


            } else if (purchaseInput.equals(optionsA2)) {
                currentItem.stockRemove();
                money.payment(price);

                System.out.println(currentItem.getItemName() + " " + price + " " + money.getWallet());
                System.out.println(slogan);

            } else if (purchaseInput.equals(optionsA3)) {
                currentItem.stockRemove();
                money.payment(price);

                System.out.println(currentItem.getItemName() + " " + price + " " + money.getWallet());
                System.out.println(slogan);

            } else if (purchaseInput.equals(optionsA4)) {
                currentItem.stockRemove();
                money.payment(price);

                System.out.println(currentItem.getItemName() + " " + price + " " + money.getWallet());
                System.out.println(slogan);

            } else if (purchaseInput.equals(optionsB1)) {
                currentItem.stockRemove();
                money.payment(price);

                System.out.println(currentItem.getItemName() + " " + price + " " + money.getWallet());
                System.out.println(slogan);

            } else if (purchaseInput.equals(optionsB2)) {
                currentItem.stockRemove();
                money.payment(price);

                System.out.println(currentItem.getItemName() + " " + price + " " + money.getWallet());
                System.out.println(slogan);

            } else if (purchaseInput.equals(optionsB3)) {
                currentItem.stockRemove();
                money.payment(price);

                System.out.println(currentItem.getItemName() + " " + price + " " + money.getWallet());
                System.out.println(slogan);

            } else if (purchaseInput.equals(optionsB4)) {
                currentItem.stockRemove();
                money.payment(price);

                System.out.println(currentItem.getItemName() + " " + price + " " + money.getWallet());
                System.out.println(slogan);

            } else if (purchaseInput.equals(optionsC1)) {
                currentItem.stockRemove();
                money.payment(price);

                System.out.println(currentItem.getItemName() + " " + price + " " + money.getWallet());
                System.out.println(slogan);

            } else if (purchaseInput.equals(optionsC2)) {
                currentItem.stockRemove();
                money.payment(price);

                System.out.println(currentItem.getItemName() + " " + price + " " + money.getWallet());
                System.out.println(slogan);

            } else if (purchaseInput.equals(optionsC3)) {
                currentItem.stockRemove();
                money.payment(price);

                System.out.println(currentItem.getItemName() + " " + price + " " + money.getWallet());
                System.out.println(slogan);

            } else if (purchaseInput.equals(optionsC4)) {
                currentItem.stockRemove();
                money.payment(price);

                System.out.println(currentItem.getItemName() + " " + price + " " + money.getWallet());
                System.out.println(slogan);

            } else if (purchaseInput.equals(optionsD1)) {
                currentItem.stockRemove();
                money.payment(price);

                System.out.println(currentItem.getItemName() + " " + price + " " + money.getWallet());
                System.out.println(slogan);

            } else if (purchaseInput.equals(optionsD2)) {
                currentItem.stockRemove();
                money.payment(price);

                System.out.println(currentItem.getItemName() + " " + price + " " + money.getWallet());
                System.out.println(slogan);

            } else if (purchaseInput.equals(optionsD3)) {
                currentItem.stockRemove();
                money.payment(price);

                System.out.println(currentItem.getItemName() + " " + price + " " + money.getWallet());
                System.out.println(slogan);

            } else if (purchaseInput.equals(optionsD4)) {
                currentItem.stockRemove();
                money.payment(price);

                System.out.println(currentItem.getItemName() + " " + price + " " + money.getWallet());
                System.out.println(slogan);

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