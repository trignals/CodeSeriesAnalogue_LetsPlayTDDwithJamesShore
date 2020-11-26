package finances.ui;

import static org.junit.Assert.*;

import finances.domain.AccountYear;
import finances.domain.Euro;
import finances.domain.AccountProjection;
import finances.domain.Percentage;
import org.junit.*;

public class AccountAccountProjectionTableModelTest {

    private static final int FIRST_YEAR = 2020;
    private static final int DURATION = 40;
    public static final Euro STARTING_PRINCIPAL = new Euro(10000);
    public static final Euro STARTING_PROFIT = new Euro(3000);
    public static final Percentage INTEREST = new Percentage(10);
    public static final Percentage CAPITAL_GAINS_TAX = new Percentage(25);
    private AccountProjectionTableModel model;

    @Before
    public void setup() {
        model = new AccountProjectionTableModel(new AccountProjection(DURATION, new AccountYear(FIRST_YEAR, STARTING_PRINCIPAL, STARTING_PROFIT, INTEREST, CAPITAL_GAINS_TAX)));
    }

    @Test
    public void columns() {
        assertEquals(9, model.getColumnCount());
        assertEquals("Year", model.getColumnName(0));
        assertEquals("Start Net Total", model.getColumnName(1));
        assertEquals("End Net Total", model.getColumnName(2));
    }

    @Test
    public void firstRow() {
        assertEquals("Year",FIRST_YEAR, model.getValueAt(0,0));
        assertEquals("Deposits & withdrawals", new Euro(0), model.getValueAt(0,3));
        assertEquals("Full-term Principal", STARTING_PRINCIPAL, model.getValueAt(0,6));
        assertEquals("Full-term Profit", STARTING_PROFIT, model.getValueAt(0,8));
    }

    @Test
    public void multipleRows() {
        assertEquals("Years Displayed", 41, model.getRowCount());
        assertEquals("Starting year", FIRST_YEAR, model.getValueAt(0,0));
        assertEquals("Starting principal", STARTING_PRINCIPAL, model.getValueAt(0,6));
        assertEquals("Starting profit", STARTING_PROFIT, model.getValueAt(0, 8));
        assertEquals("Last year in forecast", 2060, model.getValueAt(40,0));
//        assertNotEquals("Beyond forecast", 2061, model.getValueAt(DURATION + 1,0));
        assertEquals("Year 2 profit", new Euro(4050), model.getValueAt(1, 8));
    }
}