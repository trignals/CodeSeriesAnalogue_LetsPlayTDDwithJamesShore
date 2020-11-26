package finances.ui;

import finances.domain.*;
import finances.util.UnreachableCodeException;

import javax.swing.table.*;

public class AccountProjectionTableModel extends AbstractTableModel {
    private static final String[] COLUMN_TITLES = {"Year", "Start Net Total", "End Net Total", "Deposits",
            "Term Net Gain", "Principal Net Rate", "Full Term Principal", "Profit Net Rate", "Full Term Profit"};
    private AccountProjection accountProjection;

    public AccountProjectionTableModel(AccountProjection accountProjection) {
        this.accountProjection = accountProjection;
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
        return accountProjection.duration();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        AccountYear projectionYear = accountProjection.projectionYear(rowIndex);
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
