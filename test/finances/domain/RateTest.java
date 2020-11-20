package finances.domain;

import finances.domain.*;

import org.junit.Test;

import static org.junit.Assert.*;

public class RateTest {

    @Test
    public void constructorTest() {
        Rate intrest = new Rate(10);
        assertEquals("10.0%", intrest.toString());
    }

    @Test
    public void accrueInterest(){
        Rate rate = new Rate(10);
        assertEquals("€20", rate.appreciate(new Euro(200)).toString());
    }

}