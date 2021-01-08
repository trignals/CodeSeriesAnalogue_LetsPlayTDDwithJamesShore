package finances.ui;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    private static final long serialVersionUID = 1L;

    public static final String TITLE = "Account Projections";
    public static final Point INITIAL_POSITION = new Point(300, 300);
    public static final Dimension INITIAL_SIZE = new Dimension(1200, 400);
    private Data data;

    public Window(Data data) {
        super(TITLE);
        this.data = data;
        this.setLocation(INITIAL_POSITION);
        this.setSize(INITIAL_SIZE);
        addComponents();
    }

    private void addComponents() {
        Container contentPane = this.getContentPane();
        getContentPane().setLayout(new BorderLayout());
        contentPane.add(BorderLayout.CENTER, tableFrame());
        contentPane.add(BorderLayout.NORTH, startingYearField());
    }

    private Component tableFrame() {
        return new JScrollPane(new Table(data.getTableLayout()));
    }

    public JTextField startingYearField() {
        final YearInputField field = new YearInputField(data.getStartingYear());
        field.addTextChangedListener(new YearInputField.ChangeListener() {
            @Override
            public void textChanged() {
                data.setStartingYear(field.getYear());
            }
        });
        return field;
    }

}
