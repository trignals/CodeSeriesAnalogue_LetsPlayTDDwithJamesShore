package finances.ui;

import finances.domain.*;
import finances.util.UnreachableCodeException;

import javax.swing.table.*;

public class TabulatedModel extends AbstractTableModel {
    private static final String[] COLUMN_TITLES = {"Year", "Start Net Total", "Deposits", "Full-Term Principal",
            "Net Growth Rate Principal", "Full-Term Gains", "Net Growth Rate Gains", "Net Generated", "End Net Total"};
    private AccountProjection projection;


    public TabulatedModel(AccountProjection projection) {
        this.projection = projection;
    }

    public void setProjection(AccountProjection projection) {
        this.projection = projection;
        this.fireTableDataChanged();
    }

    public AccountProjection getProjection() {
        return projection;
    }

    //TODO spike code re-do
//    public void setProjection(AccountProjection projection) {
//        this.projection = projection;
//        this.fireTableDataChanged();
//    }

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
        AccountYear projectionYear = projection.year(rowIndex);
        switch (columnIndex) {
            case 0: return projectionYear.year();
            case 1: return projectionYear.netTotalStart();
            case 2: return projectionYear.balanceOfDeposits();
            case 3: return projectionYear.fullTermPrincipal();
            case 4: return projectionYear.principalNetGrowth();
            case 5: return projectionYear.fullTermProfit();
            case 6: return projectionYear.profitNetGrowth();
            case 7: return projectionYear.netProfitGenerated();
            case 8: return projectionYear.netTotalEnd();
            default: throw new UnreachableCodeException();
        }
    }

}
