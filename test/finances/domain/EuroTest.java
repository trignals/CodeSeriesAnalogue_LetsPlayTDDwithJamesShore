package finances.domain;

import finances.domain.Euro;
import org.junit.Test;

import static org.junit.Assert.*;

public class EuroTest {

    @Test
    public void subtraction() {
        Euro amount1 = new Euro(100);
        Euro amount2 = new Euro(20);
        Euro amount3 = new Euro(3);
        assertEquals(new Euro(80), amount1.minus(amount2));
        assertEquals(new Euro(83), amount1.minus(amount2.minus(amount3)));
    }

    @Test
    public void addition() {
        Euro amount1 = new Euro(100);
        Euro amount2 = new Euro(20);
        Euro amount3 = new Euro(3);
        assertEquals(new Euro(120), amount1.plus(amount2));
        assertEquals(new Euro(123), amount1.plus(amount2.plus(amount3)));
    }

    @Test
    public void valueObject() {
        Euro amount1a = new Euro(80);
        Euro amount1b = new Euro(80);
        Euro amount2 = new Euro(20);

        assertEquals("€80", amount1a.toString());
        assertEquals(amount1a, amount1b);
        assertNotEquals(amount1a, amount2);
        assertEquals(amount1a.hashCode(), amount1b.hashCode());
        assertNotEquals(amount1a.hashCode(), amount2.hashCode());
    }

}
