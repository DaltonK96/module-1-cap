import java.math.BigDecimal;

public class Items {
    // Each item has a name and Price
    // chips
    // Drinks
    // Gum
    // Candy

   private String itemName;
   private BigDecimal price;
   private String slotLocation;
   private String inputType;
   private int stock = 5;

    String crunch = "Crunch Crunch, Crunch!";
    String munch = "Munch Munch, Mmm-Good!";
    String cheersGlug = "Cheers Glug, Glug!";
    String chewPop = "Chew Chew, Pop!";


   public Items (String itemName, BigDecimal price, String slotLocation, String inputType){
       this.itemName=itemName;
       this.price=price;
       this.slotLocation=slotLocation;
       this.inputType=inputType;

   }

   public int stockRemove() {
       stock = stock - 1;
               return stock;
   }

   public void chips()
   {
       System.out.println(crunch);
   }

    public void candy()
    {
        System.out.println(munch);
    }

    public void drinks()
    {
        System.out.println(cheersGlug);
    }

    public void gum()
    {
        System.out.println(chewPop);
    }

    public String getInputType() {
        return inputType;
    }

    public int getStock() {
        return stock;
    }

    public String getItemName() {
        return itemName;
    }

    public String getSlotLocation() {
        return slotLocation;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
