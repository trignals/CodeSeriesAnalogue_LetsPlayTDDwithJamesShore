package finances.ui;

import javax.swing.*;

public class Application {
    private static final long serialVersionUID = 1L;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Window(new Data()).setVisible(true);
            }
        });
    }

}
