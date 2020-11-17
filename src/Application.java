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
        AccountYearTableModel model = new AccountYearTableModel(2020, 2060, new Euro(10000), new Euro(3000));

        JTable table = new JTable(model);
        return new JScrollPane(table);
    }

    public static void main(String[] args) {
        new Application().setVisible(true);
    }

}
