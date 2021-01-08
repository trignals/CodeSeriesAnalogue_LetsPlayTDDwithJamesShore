package finances.ui;

import finances.domain.InvalidYear;
import finances.domain.ValidYear;
import finances.domain.Year;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class YearInputFieldTest {

    private YearInputField field;
    private YearInputField historicalField;
    private ValidYear yearZero = new ValidYear(0);

    @Before
    public void setup() {
        field = new YearInputField(Year.parse("2021"));
        historicalField = new YearInputField(Year.parse("2019"));
    }

    @Test
    public void canConstructWithValue() {
        YearInputField field = new YearInputField(Year.parse("2021"));
        assertEquals(new ValidYear(2021), field.getYear());
    }

    @Test
    public void canGetValue() {
        assertEquals(new ValidYear(2019), historicalField.getYear());
    }

    @Test
    public void canSetText() {
        YearInputField field = new YearInputField(Year.parse("2021"));
        field.setText("2048");
        assertEquals(new ValidYear(2048), field.getYear());
    }

    @Test
    public void emptyString() {
        field.setText("");
        assertEquals("empty input generates a valid year", yearZero, field.getYear());
    }

    @Test
    public void negativeZero() {
        field.setText("-0");
        assertEquals("negative zero generates an invalid year", new InvalidYear(), field.getYear());
    }

    @Test
    public void negatives() {
        field.setText("-200");
        assertEquals("negative input generates an invalid year", new InvalidYear(), field.getYear());
    }

    @Test
    public void nonNumbers() {
        field.setText("20d");
        assertEquals("non numerical input generates an invalid year", new InvalidYear(), field.getYear());
    }

    @Test
    public void canCallFunctionWhenTextChanges() {
        final boolean[] changed = { false };
        YearInputField.ChangeListener listener = new YearInputField.ChangeListener() {
            public void textChanged() {
                changed[0] = true;
            }
        };

        field.addTextChangedListener(listener);
        assertEquals("TextChanged() should not yet have been called", false, changed[0]);
        field.setText("2048");
        assertEquals("TextChanged() should now have been called", true, changed[0]);
    }

    @Test
    public void inputFieldRenderedByDomainClassWhenInputChanges() throws Exception {
        field.setText("2025");
        assertEquals("text colour starts as black", Color.BLACK, field.getForeground());
        field.setText("1234");
        assertEquals("text colour should change to red for ended years", Color.RED, field.getForeground());
    }

}