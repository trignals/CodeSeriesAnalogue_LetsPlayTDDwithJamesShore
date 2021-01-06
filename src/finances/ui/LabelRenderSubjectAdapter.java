package finances.ui;

import javax.swing.*;
import java.awt.*;

class LabelRenderSubjectAdapter implements RenderSubject {
    private JLabel label;

    public LabelRenderSubjectAdapter(JLabel label) {
       this.label =label;
    }

    @Override
    public void setText(String text) {
        label.setText(text);
    }

    @Override
    public void setIcon(Icon icon) {
        label.setIcon(icon);
    }

    @Override
    public void setToolTipText(String text) {
        label.setToolTipText(text);
    }

    @Override
    public void setForegroundColor(Color color) {
        label.setForeground(color);

    }
}
