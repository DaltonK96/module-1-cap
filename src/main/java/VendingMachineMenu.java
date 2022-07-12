import com.techelevator.view.Menu;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Scanner;

public class VendingMachineMenu
{

    private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
    private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
    private static final String MAIN_MENU_OPTION_EXIT = "Exit";
    private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT};
    private final Menu menu;

    private static final String PURCHASE_MENU_OPTIONS_FEED_MONEY = "Feed money";
    private static final String PURCHASE_MENU_OPTIONS_SELECT_PRODUCT = "Select product";
    private static final String PURCHASE_MENU_OPTIONS_FINISH_TRANSACTION = "Finish transaction";
    private static final String[] MAIN_PURCHASE_OPTIONS = {PURCHASE_MENU_OPTIONS_FEED_MONEY, PURCHASE_MENU_OPTIONS_SELECT_PRODUCT,
            PURCHASE_MENU_OPTIONS_FINISH_TRANSACTION};


    public VendingMachineMenu(Menu menu) {
        this.menu = menu;
    }

    public void run() throws FileNotFoundException
    {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.getItems();

        Wallet wallet = new Wallet();

        while (true)
        {
            String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

            if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS))
            {
                vendingMachine.displayItems();
            } else if (choice.equals(MAIN_MENU_OPTION_PURCHASE))
            {
                while (true)
                {
                    String purchaseChoice = (String) menu.getChoiceFromOptions(MAIN_PURCHASE_OPTIONS);

                    Logger log = new Logger();

                    System.out.println(" Current Money Provided " + wallet.getWallet());
                    if (purchaseChoice.equals(PURCHASE_MENU_OPTIONS_FEED_MONEY)) {

                        System.out.println("Please enter the whole dollar amount you want to feed: ");
                        Scanner moneyInput = new Scanner(System.in);
                        String moneyEntered = moneyInput.nextLine();

                        try {
                            int moneyInt = Integer.parseInt(moneyEntered);
                            BigDecimal moneyBigDecimal = BigDecimal.valueOf(moneyInt);

                            wallet.feedMoney(moneyBigDecimal, log);
                        }catch (NumberFormatException e)
                        {
                            System.out.println("Please enter a whole dollar amount.");
                        }

                        System.out.println("New Balance is: " + wallet.getWallet());


                    } else if (purchaseChoice.equals(PURCHASE_MENU_OPTIONS_SELECT_PRODUCT)) {
                        vendingMachine.displayItems();

                        vendingMachine.purchaseItems(wallet, log);


                    } else if (purchaseChoice.equals(PURCHASE_MENU_OPTIONS_FINISH_TRANSACTION)) {
                        wallet.finishTransaction(wallet, log);
                        break;
                    }

                }
            } else if (choice.equals(MAIN_MENU_OPTION_EXIT))
            {
                break;
            }
        }
    }


    public static void main (String[]args) throws FileNotFoundException
    {
        Menu menu = new Menu(System.in, System.out);
        VendingMachineMenu VM = new VendingMachineMenu(menu);
        VM.run();
    }
}