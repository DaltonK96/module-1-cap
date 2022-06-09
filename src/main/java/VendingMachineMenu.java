import com.techelevator.view.Menu;

import java.math.BigDecimal;

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

    public void run() {
        while (true) {
            String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

            if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
                // display vending machine items
            } else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
                // do purchase
            } else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
                // Exit
            }
        }
    }

    public static void main(String[] args) {
        Menu menu = new Menu(System.in, System.out);
        VendingMachineMenu VM = new VendingMachineMenu(menu);
        VM.run();
    }
   // public Items (String itemName, BigDecimal price, String slotLocation, String inputType)

    //Items newItem = new Items{

}






