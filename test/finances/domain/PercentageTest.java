package finances.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class PercentageTest {

    @Test
    public void constructorTest() {
        Percentage intrest = new Percentage(10);
        assertEquals("10.0%", intrest.toString());
    }

    @Test
    public void accrueInterest(){
        Percentage percentage = new Percentage(10);
        assertEquals("€20", percentage.appreciate(new Euro(200)).toString());
    }

}