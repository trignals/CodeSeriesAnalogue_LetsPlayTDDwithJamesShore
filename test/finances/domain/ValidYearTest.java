package finances.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ValidYearTest {
    private final int VALUE_1a = 2010;
    private final int VALUE_1b = 2010;
    private final int VALUE_2 = 2021;
    private ValidYear twentytwenty;

    @Before
    public void setup() {
        twentytwenty = new ValidYear(2020);
    }

    @Test
    public void getYear() {
        Year year = new ValidYear(VALUE_2);
        assertEquals(new ValidYear(VALUE_2 + 1), year.subsequentYear());
    }

    @Test
    public void valueObject() {
        Year year1a = new ValidYear(VALUE_1a);
        Year year1b = new ValidYear(VALUE_1b);
        Year year2 = new ValidYear(VALUE_2);

        assertEquals(new ValidYear(VALUE_1a + 1), year1a.subsequentYear());
        assertEquals(VALUE_1a, VALUE_1b);
        assertFalse("allow comparing to null", year1a.equals(null));
        assertNotEquals(VALUE_1a, VALUE_2);
        assertEquals(year1a.hashCode(), year1b.hashCode());
        assertNotEquals(year1a.hashCode(), year2.hashCode());
    }
}