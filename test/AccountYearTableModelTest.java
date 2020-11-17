import static org.junit.Assert.*;
import org.junit.*;
import org.junit.experimental.theories.suppliers.TestedOn;

public class AccountYearTableModelTest {

    private static final int STARTING_YEAR = 2020;
    private static final int ENDING_YEAR = 2060;
    public static final Euro STARTING_PRINCIPAL = new Euro(10000);
    public static final Euro STARTING_PROFIT = new Euro(3000);
    private AccountYearTableModel model;

    @Before
    public void setup() {
        model = new AccountYearTableModel(STARTING_YEAR, ENDING_YEAR, STARTING_PRINCIPAL, STARTING_PROFIT);
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
        assertEquals(STARTING_YEAR, model.getValueAt(0,0));
        assertEquals(new Euro(0), model.getValueAt(0,3));
        assertEquals(STARTING_PRINCIPAL, model.getValueAt(0,6));
        assertEquals(STARTING_PROFIT, model.getValueAt(0,8));
    }

    @Test
    public void multipleRows() {
        assertEquals(41, model.getRowCount());
        assertEquals(STARTING_YEAR, model.getValueAt(0,0));
        assertEquals(STARTING_PROFIT, model.getValueAt(0, 8));
        assertEquals(ENDING_YEAR, model.getValueAt(40,0));
        assertEquals(new Euro(4050), model.getValueAt(1, 8));
    }
}