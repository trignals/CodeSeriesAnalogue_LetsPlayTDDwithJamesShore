package finances.domain;

import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

import static org.junit.Assert.*;

public class InvalidYearsTest {
    private InvalidYear nonYearA;
    private InvalidYear nonYearB;
    private ValidYear valid;

    @Before
    public void setup() {
        nonYearA = new InvalidYear();
        nonYearB = new InvalidYear();
        valid = new ValidYear(13);
    }

    @Test
    public void checkIsValid() {
        assertFalse(nonYearA.isValid());
    }

    @Test
    public void checkEquals() {
        assertFalse(nonYearA.equals(valid));
        assertFalse(valid.equals(nonYearA));
    }


    @Test
    public void renderToSwingLabel() {
        JLabel label = new JLabel();
        nonYearA.render(label);

        URL iconURL = getClass().getResource("invalid_year.gif");
        ImageIcon expectedIcon = new ImageIcon(iconURL);
        ImageIcon actualIcon = (ImageIcon)label.getIcon();
        assertEquals("icon image", expectedIcon.getImage(), actualIcon.getImage());
        assertEquals("icon discription", "Invalid year entry", actualIcon.getDescription());

    }

    @Test
    public void renderingShouldResetLabelToDefaultState() {
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon());
        label.setText("reset this text to null");
        label.setToolTipText("should not see this tool tip");
        label.setForeground(Color.BLUE);

        nonYearA.render(label);

        assertNull("should have no text", label.getText());
        assertNull("should have no tool tip", label.getToolTipText());
        assertEquals("foreground colour", Color.RED, label.getForeground());
    }

    @Test
    public void valueObject() {
        assertEquals("YEAR ???", nonYearA.toString());
        assertTrue("invalid years are always equal", nonYearA.equals(nonYearB));
        assertFalse("allow comparing to null", nonYearA.equals(null));
        assertFalse("invalid years don't equal anything else", nonYearA.equals(valid));
        assertTrue("invalid years have the same hash code", nonYearA.hashCode() == nonYearB.hashCode());

    }

}