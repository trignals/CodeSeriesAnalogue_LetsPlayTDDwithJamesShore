import org.junit.Test;

import static org.junit.Assert.*;

public class AccountYearTest {

    @Test
    public void changesToDeposits() {
        AccountYear account = new AccountYear();
        account.deposit(new Euro(200));
        assertEquals("€200", account.netBalance().toString());
        account.withdraw(new Euro(100));
        assertEquals("€100", account.netBalance().toString());
    }
    
    @Test
    public void parameteriseNewAccounts() {
        AccountYear account = new AccountYear(new Euro(100));
        assertEquals("€100", account.netBalance().toString());
        AccountYear account2 = new AccountYear(new Euro(2000), 10);
        account2.newYear();
        assertEquals("€200", account2.endCapitalGains.toString());
    }

}






























