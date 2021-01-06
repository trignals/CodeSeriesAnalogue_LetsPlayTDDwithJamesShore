package finances.ui;

import javax.swing.*;
import javax.swing.event.*;
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

    public JTextField startingYearField() {
        final YearInputField field = new YearInputField(data.startingYear());

        field.getDocument().addDocumentListener(new DocumentListener() {
            @Override public void insertUpdate(DocumentEvent e) { updateStartingYear(); }
            @Override public void removeUpdate(DocumentEvent e) { updateStartingYear(); }
            @Override public void changedUpdate(DocumentEvent e) { updateStartingYear(); }
            private void updateStartingYear() {
                data.setStartingYear(field.getYear());
            }
        });
        return field;
    }

    private Component tableFrame() {
        return new JScrollPane(new Table(data.tabulatedModel()));
    }

}
