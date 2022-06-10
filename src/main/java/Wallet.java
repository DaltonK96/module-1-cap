import java.math.BigDecimal;

public class Wallet {

    private BigDecimal wallet = new BigDecimal("0.00" );
    private BigDecimal feedMoney = new BigDecimal("1.00");
    public BigDecimal getWallet() {
        return wallet;
    } public Wallet (){
        this.wallet= wallet;
    }
   public BigDecimal feedMoney(){
         wallet = wallet.add(feedMoney);
         return wallet;
   }

   public BigDecimal payment(BigDecimal price) {
        wallet = wallet.subtract(price);
        return wallet;


   }
}
