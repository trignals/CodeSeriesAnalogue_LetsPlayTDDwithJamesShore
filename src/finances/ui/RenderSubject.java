package finances.ui;

import javax.swing.*;
import java.awt.*;

public interface RenderSubject {

    void setText(String text);

    void setIcon(Icon icon);

    void setToolTipText(String toolTipText);

    void setForegroundColor(Color colour);
}