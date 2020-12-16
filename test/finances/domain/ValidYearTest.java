package finances.domain;

import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;

import java.awt.*;

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
    public void renderToSwingLabel() {
        JLabel label = new JLabel();
        twentytwenty.render(label);
        assertEquals(twentytwenty.toString(), label.getText());
    }

    @Test
    public void renderingShouldResetLabelToDefaultState() {
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon());
        label.setToolTipText("This tool tip should not have appeared");
        label.setForeground(Color.BLUE);

        twentytwenty.render(label);

        assertNull("should not have Icon", label.getIcon());
        assertNull("should not have tooltip", label.getToolTipText());
        assertEquals("foreground colour", Color.BLACK, label.getForeground());
    }

    @Test
    public void renderEndedYearsRed() {
        JLabel label = new JLabel();
        ValidYear twentyten = new ValidYear(2010);
        twentyten.render(label);
        assertEquals("foreground colour should be red if year is < current", Color.RED, label.getForeground());
    }

    @Test
    public void renderCurrentAndFutureYearsBlack() {
        JLabel label = new JLabel();
        twentytwenty.render(label);
        assertEquals("foreground colour is black if year is not yet ended", Color.BLACK, label.getForeground());
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