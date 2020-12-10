package finances.ui;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.*;

public class ApplicationFrame extends JFrame {
    private static final long serialVersionUID = 1L;

    public static final String TITLE = "Account Projections";
    public static final Dimension INITIAL_SIZE = new Dimension(1200, 400);
    public static final Point INITIAL_POSITION = new Point(300, 300);
    private ProjectionModel projectionModel;

    public ApplicationFrame(ProjectionModel model) {
        super(TITLE);
        this.projectionModel = model;
        this.setSize(INITIAL_SIZE);
        this.setLocation(INITIAL_POSITION);
        addComponents();
    }

    private void addComponents() {
        Container contentPane = this.getContentPane();
        getContentPane().setLayout(new BorderLayout());
        contentPane.add(BorderLayout.CENTER, tableFrame());
        contentPane.add(BorderLayout.NORTH, startingYearField());
    }

    public JTextField startingYearField() {
        JTextField field = new JTextField();

        field.getDocument().addDocumentListener(new DocumentListener() {
            @Override public void insertUpdate(DocumentEvent e) { updateStartingYear(); }
            @Override public void removeUpdate(DocumentEvent e) { updateStartingYear(); }
            @Override public void changedUpdate(DocumentEvent e) { updateStartingYear(); }
            private void updateStartingYear() {
                try {
                    int value = Integer.parseInt(field.getText());
                    projectionModel.setStartingYear(value);
                } catch (NumberFormatException e) { }
            }
        });
        return field;
    }

    private Component tableFrame() {
        return new JScrollPane(new TableFrame(projectionModel.tabulatedModel()));
    }

}
