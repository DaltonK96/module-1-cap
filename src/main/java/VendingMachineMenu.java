import com.techelevator.view.Menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

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
                File log = new File("C:\\Users\\Student\\workspace\\nlr-8-module-1-capstone-orange-team-4\\src\\main\\java\\Log.txt");
                try (PrintWriter logWriter = new PrintWriter(log)) {
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                    Date date = new Date();



                    System.out.println(" Current Money Provided " + wallet.getWallet());
                    if (purchaseChoice.equals(purchaseMenuOptionsFeedMoney)) {
                        wallet.feedMoney();
                        System.out.println("New Balance is: " + wallet.getWallet());
                       logWriter.println(formatter.format(date)+" FEED MONEY:"  + wallet.getWallet()+ wallet.getWallet());


                    } else if (purchaseChoice.equals(purchaseMenuOptionsSelectProduct)) {
                        vendingMachine.getItems();
                        vendingMachine.displayItems();

                        vendingMachine.purchaseItems(wallet);
                        logWriter.println(formatter.format(date)+ vendingMachine.purchaseItems(wallet).currentItem + wallet.getWallet()+ wallet.getWallet())

                    } else if (purchaseChoice.equals(purchaseMenuOptionsFinishTransaction)) {
                        wallet.finishTransaction(wallet);

                    }
                } catch (FileNotFoundException ex)
                    System.out.println("File not found");

                } else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
                    // Exit
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






