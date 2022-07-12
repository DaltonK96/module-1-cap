import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.*;


public class VendingMachine
{
    Map<String, Items> allItems = new HashMap<>();

    //slogan options
    private static final String chipSlogan = "Crunch Crunch, Crunch!";
    private static final String candySlogan = "Munch Munch, Mmm-Good!";
    private static final String drinkSlogan = "Cheers Glug, Glug!";
    private static final String gumSlogan = "Chew Chew, Pop!";

    //slot options
    private static final String optionsA1 = "A1";
    private static final String optionsA2 = "A2";
    private static final String optionsA3 = "A3";
    private static final String optionsA4 = "A4";
    private static final String optionsB1 = "B1";
    private static final String optionsB2 = "B2";
    private static final String optionsB3 = "B3";
    private static final String optionsB4 = "B4";
    private static final String optionsC1 = "C1";
    private static final String optionsC2 = "C2";
    private static final String optionsC3 = "C3";
    private static final String optionsC4 = "C4";
    private static final String optionsD1 = "D1";
    private static final String optionsD2 = "D2";
    private static final String optionsD3 = "D3";
    private static final String optionsD4 = "D4";

    List<String> options = Arrays.asList(optionsA1,optionsA2,optionsA3,optionsA4,optionsB1,optionsB2,optionsB3,optionsB4,
            optionsC1,optionsC2,optionsC3,optionsC4,optionsD1,optionsD2,optionsD3,optionsD4);


    //method to purchase an item as long as you have enough money in your wallet
    public void purchaseItems(Wallet money, Logger log)
    {
        //gets user input for the slot number of the item they'd like to select
        Scanner purchase = new Scanner(System.in);
        System.out.println("Please enter item selection: ");
        String purchaseInput = purchase.nextLine();

        String slogan = "";


        //makes sure the user input is a valid slot number
        if (options.contains(purchaseInput))
        {
            //gets the current item info based off of the user input
            Items currentItem = allItems.get(purchaseInput);
            BigDecimal price = currentItem.getPrice();
            int comparingBalance = price.compareTo(money.getWallet());
            int currentItemStock = currentItem.getStock();
            String currentItemName = currentItem.getItemName();

            //makes sure that the user has enough money in their wallet to afford item
            if (comparingBalance < 0)
            {
                //makes sure the item is not sold out
                if (currentItemStock != 0)
                {
                    //sets to slogan equal to the correct one based off of the item type
                    switch (currentItem.getInputType()) {
                        case "Chip":
                            slogan = chipSlogan;
                            break;
                        case "Candy":
                            slogan = candySlogan;
                            break;
                        case "Drink":
                            slogan = drinkSlogan;
                            break;
                        case "Gum":
                            slogan = gumSlogan;
                            break;
                    }

                    //removes the stock from the item in vending machine
                    currentItem.stockRemove();
                    //removes the money from the users wallet
                    money.payment(price);

                    //prints out the item name, price of item bought, and current balance in wallet
                    System.out.println(currentItemName + " " + price + " " + money.getWallet());
                    //prints the item slogan
                    System.out.println(slogan);

                    //logs the purchase to the log.txt file
                    log.log(" " + currentItemName + " " + currentItem.getSlotLocation() + " $" + price + " $" + money.getWallet());
                }//if the item is sold out then print this
                else
                {
                    System.out.println(currentItemName + " is sold out!");
                }
            }
        }//if the user inputs an invalid code then do this
        else
        {
            System.out.println(purchaseInput + " is an Invalid Code!");
        }
    }


    //gets all the items available from the vendingmachine.csv file
    public void getItems() throws FileNotFoundException
    {
        File myFile = new File("C:\\Users\\Student\\workspace\\nlr-8-module-1-capstone-orange-team-4\\vendingmachine.csv");

        try (Scanner vendingFile = new Scanner(myFile))
        {
            while (vendingFile.hasNextLine())
            {

                String currentLine = vendingFile.nextLine();
                String[] currentItem = currentLine.split("\\|");
                BigDecimal price = new BigDecimal(currentItem[2]);

                Items newItem = new Items(currentItem[1], price, currentItem[0], currentItem[3]);

                allItems.put(currentItem[0], newItem);

            }

        } catch (FileNotFoundException ex)
        {
            System.out.println("Cannot Find File.");
        }

    }


    //displays the items to the screen
    public void displayItems()
    {
        for (Items value : allItems.values())
        {
            if (value.getStock() == 0)
            {
                System.out.println(value.getSlotLocation() + " " + value.getItemName() + " " + value.getPrice() + " SOLD OUT");
            } else
            {
                System.out.println(value.getSlotLocation() + " " + value.getItemName() + " " + value.getPrice() + " Stock amount = " + value.getStock());
            }
        }
    }
}