package finances.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class AccountProjectionTest {

    @Test
    public void yearRange() {
        AccountProjection accountProjection = new AccountProjection(40, new AccountYear(
                2020, new Euro(10000), new Euro(3000), new Percentage(10), new Percentage(25)));
        assertEquals(2060, accountProjection.lastYear());
        AccountYear year = accountProjection.year(0);
        assertEquals(new Euro(10000), accountProjection.year(0).fullTermPrincipal());
        assertEquals(new Euro(3000), accountProjection.year(0).fullTermProfit());
        assertEquals("Year 1 Profit", new Euro(4050), accountProjection.year(1).fullTermProfit());
    }

    @Test
    public void PrecisionOfCumulativeOperationsTest() {
        AccountProjection accountProjection = new AccountProjection(40, new AccountYear(2020, new Euro(7000), new Euro(2250), new Percentage(10), new Percentage(25)));
        assertEquals( 2060, accountProjection.year(40).year());
        assertEquals("ending balance 2060", new Euro(375139), accountProjection.year(40).netTotalEnd());
    }
}