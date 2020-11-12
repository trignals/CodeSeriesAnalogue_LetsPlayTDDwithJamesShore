import org.junit.Test;

import static org.junit.Assert.*;

public class IntrestTest {

    @Test
    public void constructorTest() {
        Interest intrest = new Interest(10);
        assertEquals("10.0%", intrest.toString());
    }

    @Test
    public void accrueInterest(){
        Interest interest = new Interest(10);
        assertEquals("€20", interest.calculateInterest(new Euro(200)).toString());
    }

}