package finances.util;

import javax.swing.*;
import java.net.URL;

public class Resource {
    public ImageIcon invalidYearIcon() {
        URL iconUrl = getClass().getResource("invalid_year.png");
        return new ImageIcon(iconUrl, "Invalid year");
    }
}
