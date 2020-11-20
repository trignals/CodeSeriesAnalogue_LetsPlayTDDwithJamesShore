package finances.ui;

import finances.domain.*;

import java.awt.*;
import javax.swing.*;

public class Application extends JFrame {
    private static final long serialVersionUID = 1L;

    public Application() {
        this.setSize(1200, 400);
        this.setLocation(1900, 300);

        Container content = this.getContentPane();
        content.add(table());
    }

    private JScrollPane table() {
        AccountYear startingYear = new AccountYear(2020, new Euro(10000), new Euro(3000),
                new Rate(10), new Rate(25));
        ProjectionTableModel model = new ProjectionTableModel(new Projection(40, startingYear));

        JTable table = new JTable(model);
        return new JScrollPane(table);
    }

    public static void main(String[] args) {
        new Application().setVisible(true);
    }

}
