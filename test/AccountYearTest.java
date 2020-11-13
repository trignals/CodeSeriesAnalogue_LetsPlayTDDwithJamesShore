import org.junit.Test;

import static org.junit.Assert.*;

public class AccountYearTest {

    @Test
    public void changesToDeposits() {
        AccountYear account = new AccountYear();
        account.deposit(new Euro(200));
        assertEquals("€200", account.testBalance().toString());
        account.withdraw(new Euro(100));
        assertEquals("€100", account.testBalance().toString());
    }

    @Test
    public void calculateInterest() {
        AccountYear account = new AccountYear(new Euro(100));
        assertEquals("€100", account.testBalance().toString());
        AccountYear account2 = new AccountYear(new Euro(2000), new Interest(10));
        account2.newYear();
        assertEquals("€200", account2.endNetGains.toString());
        AccountYear account3 = new AccountYear(new Euro(1700), new Euro(300), new Interest(10));
        assertEquals("€300", account3.startNetGains.toString());
        account3.newYear();
        assertEquals("€500", account3.endNetGains.toString());
    }

    @Test
    public void calculateCapitalGainsTax() {
        AccountYear account = new AccountYear(new Euro(0), new Euro(300), new Interest(10), new TaxRate(25));
        assertEquals("€400", account.grossProfit().toString());
    }

}
