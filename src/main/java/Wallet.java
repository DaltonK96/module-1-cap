import java.math.BigDecimal;

public class Wallet {

    private BigDecimal wallet = new BigDecimal("0.00");
    private BigDecimal feedMoney = new BigDecimal("5.00");

    public BigDecimal getWallet() {
        return wallet;
    }

    public Wallet() {
        this.wallet = wallet;
    }

    public BigDecimal feedMoney() {
        wallet = wallet.add(feedMoney);
        return wallet;
    }

    public BigDecimal payment(BigDecimal price) {
        wallet = wallet.subtract(price);
        return wallet;


    }

    public void finishTransaction(Wallet remainingMoney) {
        BigDecimal noMoney = new BigDecimal("0.00");

        BigDecimal remainingMoneyWallet = remainingMoney.getWallet();

        BigDecimal quarter = new BigDecimal("0.25");
        BigDecimal dime = new BigDecimal("0.10");
        BigDecimal nickel = new BigDecimal("0.05");

        int counter = 0;
        int quarterCounter = 0;
        int nickelCounter = 0;
        int dimeCounter = 0;
        BigDecimal broke = new BigDecimal("0.00");

        int comparingBalance = remainingMoneyWallet.compareTo(noMoney);
        while (comparingBalance < 0) {
            if (remainingMoneyWallet.remainder(quarter).compareTo(broke)==0) {
                quarterCounter++;
                remainingMoneyWallet = remainingMoneyWallet.subtract(quarter);

                }

               else if (remainingMoneyWallet.remainder(dime).compareTo(broke)==0) {
                    dimeCounter++;
                    remainingMoneyWallet = remainingMoneyWallet.subtract(dime);


                    }else if (remainingMoneyWallet.remainder(nickel).compareTo(broke)==0) {
                        nickelCounter++;
                        remainingMoneyWallet = remainingMoneyWallet.subtract(nickel);

                    }
                } System.out.println("Please collect your change! ");
                System.out.println("Quarters:" + quarterCounter);
                System.out.println("Dimes:" + dimeCounter);
                System.out.println("Nickels:" + nickelCounter);
            }
        }
