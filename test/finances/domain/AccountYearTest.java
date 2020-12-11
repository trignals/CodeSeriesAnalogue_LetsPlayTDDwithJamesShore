package finances.domain;

import org.junit.Test;
import static org.junit.Assert.*;

public class AccountYearTest {

    @Test
    public void accessMethods() {
        AccountYear account = new AccountYear(new ValidYear(2020), new Euro(10000), new Euro(2000),
                new Percentage(10), new Percentage(25));
        assertEquals("€12000", account.netTotalStart().toString());
        assertEquals("€10000", account.fullTermPrincipal().toString());
        assertEquals("€2000", account.fullTermProfit().toString());
        assertEquals("7.5%", account.principalNetGrowth().toString());
        assertEquals("10.0%", account.profitNetGrowth().toString());
        assertEquals("€0", account.balanceOfDeposits().toString());
        assertEquals("€950", account.netProfitGenerated().toString());
        assertEquals("€12950", account.netTotalEnd().toString());
    }

    @Test
    public void startNewYear() {
        AccountYear account2020 = new AccountYear(new ValidYear(2020), new Euro(10000), new Euro(2000),
                new Percentage(10), new Percentage(25));
        account2020.deposit(new Euro(6000));
        AccountYear account2021 = account2020.newYear();
        assertEquals(new ValidYear(2020), account2020.year());
        assertEquals(new ValidYear(2021), account2021.year());
        assertEquals("€18950", account2021.netTotalStart().toString());
        assertEquals("€16000", account2021.fullTermPrincipal().toString());
        assertEquals("€2950", account2021.fullTermProfit().toString());
        assertEquals("7.5%", account2021.principalNetGrowth().toString());
        assertEquals("10.0%", account2021.profitNetGrowth().toString());
        assertEquals("€0", account2021.balanceOfDeposits().toString());
        assertEquals("€1495", account2021.netProfitGenerated().toString());
        assertEquals("€20445", account2021.netTotalEnd().toString());
    }

    @Test
    public void withdrawPrincipal() {
        AccountYear account = new AccountYear(new ValidYear(2020), new Euro(10000), new Euro(2000),
                new Percentage(10), new Percentage(25));
        account.withdrawAmount(new Euro(4000));
        assertEquals("€12000", account.netTotalStart().toString());
        assertEquals("€0", account.balanceOfDeposits().toString());
        assertEquals("€6000", account.fullTermPrincipal().toString());
    }

    @Test
    public void withdrawProfit() {
        AccountYear account = new AccountYear(new ValidYear(2020), new Euro(10000), new Euro(2000),
                new Percentage(10), new Percentage(25));
        account.withdrawAmount(new Euro(11000));
        assertEquals("€12000", account.netTotalStart().toString());
        assertEquals("€0", account.balanceOfDeposits().toString());
        assertEquals("€0", account.fullTermPrincipal().toString());
        assertEquals("€1000", account.fullTermProfit().toString());
    }

    @Test
    public void showAccountOverdrawnAsNegativeDeposit() {
        AccountYear account = new AccountYear(new ValidYear(2020), new Euro(10000), new Euro(2000),
                new Percentage(10), new Percentage(25));
        account.withdrawAmount(new Euro(13000));
        assertEquals("€12000", account.netTotalStart().toString());
        assertEquals("€-1000", account.balanceOfDeposits().toString());
        assertEquals("€0", account.fullTermPrincipal().toString());
        assertEquals("€0", account.fullTermProfit().toString());
        account.withdrawAmount(new Euro(100));
        assertEquals("€-1100", account.balanceOfDeposits().toString());
    }

    @Test
    public void twoYearsAccountUsage() {
        AccountYear account2020 = new AccountYear(new ValidYear(2020), new Euro(7000), new Euro(3000),
                new Percentage(10), new Percentage(25));
        account2020.deposit(new Euro(11000));
        account2020.withdrawAmount(new Euro(11000));
        account2020.withdrawAmount(new Euro(7750));
        account2020.deposit(new Euro(5000));
        assertEquals("€10000", account2020.netTotalStart().toString());
        assertEquals("€0", account2020.fullTermPrincipal().toString());
        assertEquals("€2250", account2020.fullTermProfit().toString());
        assertEquals("7.5%", account2020.principalNetGrowth().toString());
        assertEquals("10.0%", account2020.profitNetGrowth().toString());
        assertEquals("€5000", account2020.balanceOfDeposits().toString());
        assertEquals("€225", account2020.netProfitGenerated().toString());
        assertEquals("€7475", account2020.netTotalEnd().toString());
        AccountYear account2021 = account2020.newYear();
        account2021.withdrawAmount(new Euro(2725));
        account2021.deposit(new Euro(11500));
        assertEquals("€7475", account2021.netTotalStart().toString());
        assertEquals("€2275", account2021.fullTermPrincipal().toString());
        assertEquals("€2475", account2021.fullTermProfit().toString());
        assertEquals("7.5%", account2021.principalNetGrowth().toString());
        assertEquals("10.0%", account2021.profitNetGrowth().toString());
        assertEquals("€11500", account2021.balanceOfDeposits().toString());
        assertEquals("€418", account2021.netProfitGenerated().toString());
        assertEquals("€16668", account2021.netTotalEnd().toString());
    }
}
