package finances.ui;
import finances.domain.SelfRenderable;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;


public class TableFrame extends JTable {
    private static final long serialVersionUID = 1L;

    public static final Color EVEN_ROW_BACKGROUND_COLOUR = Color.WHITE;
    public static final Color ODD_ROW_BACKGROUND_COLOUR = new Color(241, 241, 235);
    public static final Color SELECTION_BACKGROUND_COLOUR = new Color(160, 160, 235);

    public TableFrame(TableModel model) {
        super(model);
        setDefaultRenderer(SelfRenderable.class, selfRenderer());
    }

    private TableCellRenderer selfRenderer() {
        return new DefaultTableCellRenderer() {
            private static final long serialVersionUID = 1L;
            public void setValue(Object value) {
                SelfRenderable renderable = (SelfRenderable)value;
                renderable.render(this);
            }
        };
    }


    @Override
    public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
        Component cell = super.prepareRenderer(renderer, row, column);

        if (isCellSelected(row, column)) cell.setBackground(SELECTION_BACKGROUND_COLOUR);
        else if (oddRow(row)) cell.setBackground(ODD_ROW_BACKGROUND_COLOUR);
        else cell.setBackground(EVEN_ROW_BACKGROUND_COLOUR);

        return cell;
    }

    private boolean oddRow(int row) {
        return row % 2 == 1;
    }


}