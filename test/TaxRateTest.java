import org.junit.Test;

import static org.junit.Assert.*;

public class TaxRateTest {

    @Test
    public void constructorTest() {
        TaxRate capitalGains = new TaxRate(25);
        assertEquals("25.0%", capitalGains.toString());
    }

    @Test
    public void applyTax(){
        TaxRate capitalGainsTax = new TaxRate(25);
        assertEquals("€100", capitalGainsTax.dueForNet(new Euro(300)).toString());
        assertEquals("€200", capitalGainsTax.dueFromGross(new Euro(800)).toString());
    }
}
