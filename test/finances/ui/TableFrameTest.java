package finances.ui;

import static org.junit.Assert.*;

import finances.domain.AccountYear;
import finances.domain.Euro;
import finances.domain.AccountProjection;
import finances.domain.Percentage;
import org.junit.*;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

public class TableFrameTest {

    private static final int STARTING_YEAR = 2020;
    private static final int DURATION = 40;
    public static final Euro STARTING_PRINCIPAL = new Euro(10000);
    public static final Euro STARTING_PROFIT = new Euro(3000);
    public static final Percentage INTEREST = new Percentage(10);
    public static final Percentage CAPITAL_GAINS_TAX = new Percentage(25);

    private TabulatedModel model;
    private AccountYear startingYear;

    class TestListener implements TableModelListener {
        public boolean eventFired = false;
        public Integer firstRowChanged = null;
        public Integer lastRowChanged = null;

        public void tableChanged(TableModelEvent e) {
            eventFired = true;
            firstRowChanged = e.getFirstRow();
            lastRowChanged = e.getLastRow();
        }
    }

    @Before
    public void setup() {
        startingYear = new AccountYear(STARTING_YEAR, STARTING_PRINCIPAL, STARTING_PROFIT, INTEREST, CAPITAL_GAINS_TAX);
        AccountProjection projection = new AccountProjection(DURATION, startingYear);
        model = new TabulatedModel(projection);
    }

    @Test
    public void changingTheProjectionShouldChangeTableModel () {
        AccountProjection projection = new AccountProjection(0, startingYear);
        model.setProjection(projection);
        assertEquals("projection should have changed", projection, model.getProjection());
        assertEquals("change to projection should reflect in methods", 1, model.getRowCount());
    }

    @Test
    public void changingTheProjectionShouldFireUpdateEvent() {
        AccountProjection projection = new AccountProjection(0, startingYear);
        final boolean[] eventFired = { false };

        TestListener listener = new TestListener();
        model.addTableModelListener(listener);

        model.setProjection(projection);
        assertTrue("event should have fired", listener.eventFired);
        assertEquals("whole table should change (first row)", 0, listener.firstRowChanged.intValue());
        assertEquals("whole table should change (last row)", Integer.MAX_VALUE, listener.lastRowChanged.intValue());
    }

    @Test
    public void columns() {
        assertEquals(9, model.getColumnCount());
        assertEquals("Year", model.getColumnName(0));
        assertEquals("Start Net Total", model.getColumnName(1));
        assertEquals("End Net Total", model.getColumnName(8));
    }

    @Test
    public void firstRow() {
        assertEquals("Year", STARTING_YEAR, model.getValueAt(0,0));
        assertEquals("Deposits & withdrawals", new Euro(0), model.getValueAt(0,2));
        assertEquals("Full-term Principal", STARTING_PRINCIPAL, model.getValueAt(0,3));
        assertEquals("Full-term Profit", STARTING_PROFIT, model.getValueAt(0,5));
    }

    @Test
    public void multipleRows() {
        assertEquals("Years Displayed", 41, model.getRowCount());
        assertEquals("Starting year", STARTING_YEAR, model.getValueAt(0,0));
        assertEquals("Starting principal", STARTING_PRINCIPAL, model.getValueAt(0,3));
        assertEquals("Starting profit", STARTING_PROFIT, model.getValueAt(0, 5));
        assertEquals("Last year in forecast", 2060, model.getValueAt(40,0));
        assertEquals("Year 2 profit", new Euro(4050), model.getValueAt(1, 5));
    }

}