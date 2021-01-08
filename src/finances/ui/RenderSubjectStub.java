package finances.ui;

import finances.ui.RenderSubject;

import javax.swing.*;
import java.awt.*;

public class RenderSubjectStub implements RenderSubject {
    public String text;
    public Icon icon;
    public String toolTipText;
    public Color foregroundColour;

    public void setText(String text) {
        this.text = text;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public void setToolTipText(String toolTipText) {
        this.toolTipText = toolTipText;
    }

    public void setForegroundColor(Color colour) {
        this.foregroundColour = colour;
    }
}
