package finances.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class YearTest {
    @Test
    public void getYear() {
        Year year = new ValidYear(2021);
        assertEquals(2021, year.is());
    }

    @Test
    public void valueObject() {
        Year year1a = new ValidYear(2010);
        Year year1b = new ValidYear(2010);
        Year year2 = new ValidYear(2020);

        assertEquals(2010, year1a.is());
        assertEquals(year1a, year1b);
        assertNotEquals(year1a, year2);
        assertEquals(year1a.hashCode(), year1b.hashCode());
        assertNotEquals(year1a.hashCode(), year2.hashCode());
    }
}