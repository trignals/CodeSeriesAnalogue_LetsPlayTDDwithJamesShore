package finances.domain;

import finances.util.Resource;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;

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
    public void valueObject() {
        assertEquals("INVALID YEAR", nonYearA.toString());
        assertTrue("invalid years are always equal", nonYearA.equals(nonYearB));
        assertFalse("allow comparing to null", nonYearA.equals(null));
        assertFalse("invalid years don't equal anything else", nonYearA.equals(valid));
        assertTrue("invalid years have the same hash code", nonYearA.hashCode() == nonYearB.hashCode());
    }

    @Test
    public void rendersItself() {
        RenderSubjectStub subject = new RenderSubjectStub();
        nonYearA.render(new Resource(), subject);

        ImageIcon expectedIcon = new Resource().invalidYearIcon();
        ImageIcon actualIcon = (ImageIcon)subject.icon;

        assertEquals("icon image", expectedIcon.getImage(), actualIcon.getImage());
        assertEquals("icon description", "Invalid year", actualIcon.getDescription());
        assertEquals("tooltip message", "Invalid year", subject.toolTipText);
    }

    @Test
    public void renderingShouldResetLabelToDefaultState() {
        RenderSubjectStub subject = new RenderSubjectStub();
        subject.text = "text to reset";

        nonYearA.render(new Resource(), subject);
        assertNull("should have no text", subject.text);
    }
}