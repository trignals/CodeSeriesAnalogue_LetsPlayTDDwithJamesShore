package finances.domain;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class InvalidYear extends Year{
    @Override
    public Year subsequentYear() {
        return new InvalidYear();
    }

    @Override
    public boolean isValid() {
        return false;
    }

    @Override
    public String toString() {
        return "YEAR ???";
    }

    @Override
    public int hashCode() {
        return 13;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof InvalidYear);
    }

    public void render(JLabel label) {
        URL iconUrl = getClass().getResource("invalid_year.gif");
        label.setIcon(new ImageIcon(iconUrl, "Invalid year entry"));
        label.setText(null);
        label.setToolTipText(null);
        label.setForeground(Color.RED);
    }
}
