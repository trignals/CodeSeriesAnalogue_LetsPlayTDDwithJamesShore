package finances.ui;

import finances.domain.InvalidYear;
import finances.domain.ValidYear;
import finances.ui.RenderSubjectStub;
import finances.util.Resource;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

import static org.junit.Assert.assertEquals;

public class RenderSubjectStubTest {
    private ValidYear currentYear;
    private ValidYear previousYear;
    private InvalidYear nonYear;
    private RenderSubjectStub subject;

    @Before
    public void setup() {
        currentYear = new ValidYear(Calendar.getInstance().get(Calendar.YEAR));
        previousYear = new ValidYear(Integer.parseInt(currentYear.toString()) - 1);
        nonYear = new InvalidYear();
        subject = new RenderSubjectStub();
        subject.setText("should not see this text");
        subject.setForegroundColor(Color.BLUE);
        subject.setIcon(new ImageIcon());
        subject.setToolTipText("should not see this tool tip");
    }

    @Test
    public void renderValidYear_withDefaultState() {
        currentYear.render(new Resource(), subject);

        assertEquals("default to toString value of the rendered object", currentYear.toString(), subject.text);
        assertEquals("default foreground colour", Color.BLACK, subject.foregroundColour);
        assertEquals("default to no Icon", null, subject.icon);
        assertEquals("default to no tooltip", null, subject.toolTipText);
    }

    @Test
    public void renderInvalidYear_withDefaultState() {
        nonYear.render(new Resource(), subject);

        ImageIcon expectedIcon = new Resource().invalidYearIcon();
        ImageIcon actualIcon = (ImageIcon)subject.icon;
        assertEquals("default to no text", null, subject.text);
        assertEquals("default foreground colour", Color.RED, subject.foregroundColour);
        assertEquals("default to invalid year icon", expectedIcon.getImage(), actualIcon.getImage());
        assertEquals("default to descriptive tool tip", "Invalid year", subject.toolTipText);
    }

    @Test
    public void renderHistoricalValidYearsRed() {
        previousYear.render(new Resource(), subject);
        assertEquals("foreground colour should be red if that year has ended", Color.RED, subject.foregroundColour);
    }

    @Test
    public void renderCurrentAndFutureValidYearsBlack() {
        currentYear.render(new Resource(), subject);
        assertEquals("foreground colour is black if the year will end in the future", Color.BLACK, subject.foregroundColour);
    }
}
