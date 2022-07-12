import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class WalletTests
{
    @Test
    public void feedMoneyAddsWholeDollarAmount()
    {
        Wallet wallet = new Wallet();
        //BigDecimal money = wallet ;
        BigDecimal amountToAdd = new BigDecimal(1.00);
        //wallet.feedMoney(amountToAdd);

        BigDecimal result = new BigDecimal("1.00");

        //Assert.assertEquals();
    }
}
