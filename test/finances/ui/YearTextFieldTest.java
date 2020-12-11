package finances.ui;

import finances.domain.ValidYear;
import finances.domain.Year;
import org.junit.Test;

import static org.junit.Assert.*;

public class YearTextFieldTest {
    @Test
    public void canGetValue() {
        YearTextField field = new YearTextField(2013);
        assertEquals(new ValidYear(2013), field.getYear());
    }

    @Test
    public void canConstructWithValue() {
        YearTextField field = new YearTextField(2020);
        assertEquals(new ValidYear(2020), field.getYear());
    }

    @Test
    public void canSetText() {
        YearTextField field = new YearTextField(2021);
        field.setText("2048");
        assertEquals(new ValidYear(2048), field.getYear());
    }

    @Test
    public void emptyString() {
        YearTextField field = new YearTextField(2021);
        field.setText("");
        //TODO use InvalidYear here
        assertEquals("emptyString is year 0", new ValidYear(0), field.getYear());
    }

    @Test
    public void negatives() {
        YearTextField field = new YearTextField(2020);
        field.setText("-200");
        //TODO use InvalidYear here
        assertEquals("emptyString is year 0", new ValidYear(0), field.getYear());
    }

    @Test
    public void nonNumbers() {
        YearTextField field = new YearTextField(2020);
        field.setText("20d");
        //TODO use InvalidYear here
        assertEquals("emptyString is year 0", new ValidYear(0), field.getYear());
    }
}