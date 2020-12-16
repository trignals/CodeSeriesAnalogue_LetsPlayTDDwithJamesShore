package finances.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class YearTest {
    @Test
    public void parseIllegals() {
        InvalidYear invalid = new InvalidYear();
        ValidYear valid = new ValidYear(2001);
        assertEquals("x", invalid, Year.parse("x"));
        assertEquals("-40", invalid, Year.parse("-40"));
        assertEquals("2001", valid, Year.parse("2001"));
    }

}