package finances.ui;

import javax.swing.*;
import java.awt.*;

public class ApplicationFrame extends JFrame {
    private static final long serialVersionUID = 1L;

    public static final String TITLE = "Account Projections";
    public static final Dimension INITIAL_SIZE = new Dimension(1200, 400);
    public static final Point INITIAL_POSITION = new Point(300, 300);
    private ProjectionModel projectionModel = new ProjectionModel();

    public ApplicationFrame() {
        super(TITLE);
        this.setSize(INITIAL_SIZE);
        this.setLocation(INITIAL_POSITION);
        addComponents();
    }

    private void addComponents() {
        Container contentPane = this.getContentPane();
        getContentPane().setLayout(new BorderLayout());
        contentPane.add(BorderLayout.CENTER, tableFrame());
        contentPane.add(BorderLayout.NORTH, startingBalanceField());
    }

    private JTextField startingBalanceField() {
        JTextField field = new JTextField();

        //TODO spike code re-do
//        field.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                applicationModel.setStartYear(2013);
//            }
//        });
        return field;
    }

    private Component tableFrame() {
        return new JScrollPane(new TableFrame(projectionModel.tabulatedModel()));
    }

}
