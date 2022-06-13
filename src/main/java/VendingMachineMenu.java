import com.techelevator.view.Menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class VendingMachineMenu {
    // Displays Iteams
    // Getts / Setters
    // data file
    // name ,Price, type
    // Purchase - current amount and input type
    // data log
    //Exit
    //slot location
    private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
    private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
    private static final String MAIN_MENU_OPTION_EXIT = "Exit";
    private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT};
    private final Menu menu;


    public VendingMachineMenu(Menu menu) {
        this.menu = menu;
    }

    public void run() throws FileNotFoundException {
        Wallet wallet = new Wallet();

        while (true) {
            String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
            VendingMachine vendingMachine = new VendingMachine();

            if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
                // display vending machine items
                vendingMachine.getItems();
                vendingMachine.displayItems();
            } else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
                // do

                String purchaseMenuOptionsFeedMoney = "Feed money";
                String purchaseMenuOptionsSelectProduct = "Select product";
                String purchaseMenuOptionsFinishTransaction = "Finish transaction";
                String[] MAIN_PURCHASE_OPTIONS = {purchaseMenuOptionsFeedMoney, purchaseMenuOptionsSelectProduct, purchaseMenuOptionsFinishTransaction};
                String purchaseChoice = (String) menu.getChoiceFromOptions(MAIN_PURCHASE_OPTIONS);

                Logger log = new Logger();



                    System.out.println(" Current Money Provided " + wallet.getWallet());
                    if (purchaseChoice.equals(purchaseMenuOptionsFeedMoney)) {

                        System.out.println("Please enter dollar amount you want to feed: ");
                        Scanner moneyInput = new Scanner(System.in);
                        String moneyEntered = moneyInput.nextLine();
                        int moneyInt = Integer.parseInt(moneyEntered);
                        BigDecimal moneyBigDecimal = BigDecimal.valueOf(moneyInt);

                        wallet.feedMoney(moneyBigDecimal,log);
                        System.out.println("New Balance is: " + wallet.getWallet());



                    } else if (purchaseChoice.equals(purchaseMenuOptionsSelectProduct)) {
                        vendingMachine.getItems();
                        vendingMachine.displayItems();

                        vendingMachine.purchaseItems(wallet, log);


                    } else if (purchaseChoice.equals(purchaseMenuOptionsFinishTransaction)) {
                        wallet.finishTransaction(wallet, log);

                    }

                } else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
                    // Exit
                break;
                }
            }
        }


        public static void main (String[]args) throws FileNotFoundException {
            Menu menu = new Menu(System.in, System.out);
            VendingMachineMenu VM = new VendingMachineMenu(menu);
            VM.run();
        }
        // public Items (String itemName, BigDecimal price, String slotLocation, String inputType)

        //Items newItem = new Items{


    }






