package finances.ui;

import finances.domain.*;
import finances.util.UnreachableCodeException;

import javax.swing.table.*;

public class ProjectionTableModel extends AbstractTableModel {
    private static final String[] COLUMN_TITLES = {"Year", "Start Net Total", "End Net Total", "Deposits",
            "Term Net Gain", "Principal Net finances.finances.finances.ui.finances.ui.domain.finances.ui.finances.finances.ui.finances.ui.domain.finances.ui.domain.Rate", "Full Term Principal", "Profit Net finances.finances.finances.ui.finances.ui.domain.finances.ui.finances.finances.ui.finances.ui.domain.finances.ui.domain.Rate", "Full Term Profit"};
    private Projection projection;

    public ProjectionTableModel(Projection projection) {
        this.projection = projection;
    }

    @Override
    public int getColumnCount() {
        return COLUMN_TITLES.length;
    }

    @Override
    public String getColumnName(int column) {
        return COLUMN_TITLES[column];
    }

    @Override
    public int getRowCount() {
        return projection.duration();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        AccountYear projectionYear = projection.projectionYear(rowIndex);
        switch (columnIndex) {
            case 0: return projectionYear.year();
            case 1: return projectionYear.netTotalStart();
            case 2: return projectionYear.netTotalEnd();
            case 3: return projectionYear.balanceOfDeposits();
            case 4: return projectionYear.netProfitGenerated();
            case 5: return projectionYear.principalNetGrowth();
            case 6: return projectionYear.fullTermPrincipal();
            case 7: return projectionYear.profitNetGrowth();
            case 8: return projectionYear.fullTermProfit();
            default: throw new UnreachableCodeException();
        }
    }
}
