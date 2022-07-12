import java.math.BigDecimal;

public class Wallet {

    private BigDecimal wallet = new BigDecimal("0.00");

    public BigDecimal getWallet() {
        return wallet;
    }

    public Wallet() {
        this.wallet = wallet;
    }

    public BigDecimal feedMoney(BigDecimal money,Logger log)
    {
        if (money.compareTo(BigDecimal.ZERO)> 0)
        {
        wallet = wallet.add(money);

        log.log(" FEED MONEY: $" + money+ ".00 $" + getWallet());
        return wallet;
        }
        System.out.println(money + " is not a valid entry.");
        return wallet;
    }

    public BigDecimal payment(BigDecimal price) {
        wallet = wallet.subtract(price);
        return wallet;


    }

    public void finishTransaction(Wallet remainingMoney,Logger log) {

        //get the money in our wallet
        BigDecimal wallet = remainingMoney.getWallet();

        //set up variables for different coin types
        BigDecimal quarter = new BigDecimal("0.25");
        BigDecimal dime = new BigDecimal("0.10");
        BigDecimal nickel = new BigDecimal("0.05");

        log.log(" GIVE CHANGE: $" + wallet + " " + "$0.00");

        //divide wallet by a quarter to see how many quarters are needed and set to an int for a whole number
        BigDecimal numOfQuarters = wallet.divide(quarter);
        int quarterCount = numOfQuarters.intValue();
        System.out.println("Quarters: " + quarterCount);

        //remove the amount of quarters from our balance in wallet
        BigDecimal quarterMoney = quarter.multiply(BigDecimal.valueOf(quarterCount));
        wallet = wallet.subtract(quarterMoney);

        //divide wallet by a dime to see how many dimes are needed and set to an int for a whole number
        BigDecimal numOfDimes = wallet.divide(dime);
        int dimeCount = numOfDimes.intValue();
        System.out.println("Dimes: " + dimeCount);

        //remove the amount of dimes from our balance in wallet
        BigDecimal dimeMoney = dime.multiply(BigDecimal.valueOf(dimeCount));
        wallet = wallet.subtract(dimeMoney);

        //divide wallet by a nickel to see how many nickels are needed and set to an int for a whole number
        BigDecimal numOfNickels = wallet.divide(nickel);
        int nickelCount = numOfNickels.intValue();
        System.out.println("Nickels: " + nickelCount);

        //remove the amount of nickels from our balance in wallet
        BigDecimal nickelMoney = nickel.multiply(BigDecimal.valueOf(nickelCount));
        wallet = wallet.subtract(nickelMoney);

        System.out.println("Remaining Balance: " + wallet);

    }
}
