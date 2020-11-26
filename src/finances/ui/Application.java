package finances.ui;

import com.jamesshore.finances.ui.ForecastTable;
import finances.domain.*;

import java.awt.*;
import javax.swing.*;

public class Application extends ApplicationFrame {
    private static final long serialVersionUID = 1L;

    public Application() {
        this.setSize(1200, 400);
        this.setLocation(1900, 300);

        Container content = this.getContentPane();
        content.add(table());
    }

    private JScrollPane table() {
        AccountYear startingYear = new AccountYear(2020, new Euro(10000), new Euro(3000),
                new Percentage(10), new Percentage(25));
        AccountProjectionTableModel model = new AccountProjectionTableModel(new AccountProjection(40, startingYear));

        JTable table = new ForecastTable(model);
        return new JScrollPane(table);
    }

    public static void main(String[] args) {
        new Application().setVisible(true);
    }

}
