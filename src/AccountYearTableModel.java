import javax.swing.table.*;

public class AccountYearTableModel extends AbstractTableModel {
    private static final long serialSErsionUID = 1L;
    private static final String[] COLUMN_TITLES = {"Year", "Start Net Total", "End Net Total", "Deposits", "Term Net Gain", "Principal Net Rate", "Full Term Principal", "Profit Net Rate", "Full Term Profit"};

    private int startingYear;
    private int endingYear;
    private Euro startingPrincipal;
    private Euro startingProfit;
    private AccountYear[] forecast;

    public AccountYearTableModel(int startingYear, int endingYear, Euro startingPrincipal, Euro startingProfit) {
        this.startingYear = startingYear;
        this.endingYear = endingYear;
        this.startingPrincipal = startingPrincipal;
        this.startingProfit = startingProfit;
        popluateForcast();
    }


    private void popluateForcast() {
        this.forecast = new AccountYear[getRowCount()];
        forecast[0] = new AccountYear(startingPrincipal, startingProfit, new Rate(10),  new Rate(25));
        for (int i = 0; i < getRowCount() - 1; i++) {
            forecast [i +1] = forecast[i].newYear();
        }
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
        return endingYear - startingYear + 1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        AccountYear projected = forecast[rowIndex];
        switch (columnIndex) {
            case 0: return this.startingYear + rowIndex;
            case 1: return projected.startNetTotal();
            case 2: return projected.endNetTotal();
            case 3: return projected.balanceOfDeposits();
            case 4: return projected.netProfitGenerated();
            case 5: return projected.netGrowthForPrincipal();
            case 6: return projected.fullTermPrincipal();
            case 7: return projected.netGrowthForProfit();
            case 8: return projected.fullTermProfit();
            default: return "";
        }
    }
}
