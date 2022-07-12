import java.math.BigDecimal;

public class Items
{
    private String itemName;
    private BigDecimal price;
    private String slotLocation;
    private String inputType;
    private int stock = 5;


    public Items (String itemName, BigDecimal price, String slotLocation, String inputType)
    {
        this.itemName=itemName;
        this.price=price;
        this.slotLocation=slotLocation;
        this.inputType=inputType;

    }

    public int stockRemove()
    {
        stock = stock - 1;
        return stock;
    }

    //getters
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
