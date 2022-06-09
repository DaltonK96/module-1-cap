

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class VendingMachine {

    Map<String, Items> allItems = new HashMap<>();

    public void getItems() throws FileNotFoundException {

        File myFile = new File("C:\\Users\\Student\\workspace\\nlr-8-module-1-capstone-orange-team-4\\vendingmachine.csv");
        try (Scanner vendingFile = new Scanner(myFile)) {


            while (vendingFile.hasNextLine()) {

                String currentLine = vendingFile.nextLine();
                String[] currentItem = currentLine.split("\\|");
                BigDecimal price = new BigDecimal(currentItem[2]);

                Items newItem = new Items(currentItem[1], price, currentItem[0], currentItem[3]);

                allItems.put(currentItem[1], newItem);

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