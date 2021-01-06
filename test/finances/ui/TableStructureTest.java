package finances.ui;

import finances.domain.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TableStructureTest {
    private static final Year STARTING_YEAR = Year.parse("-2020");
    private static final Euro STARTING_PRINCIPAL = new Euro(7000);
    private static final Euro STARTING_BALANCE = new Euro(3000);
    private static final Percentage INTEREST = new Percentage(10);
    private static final Percentage CAPITAL_GAINS_TAX = new Percentage(25);

    private AccountYear startingYear;
    private TableStructure model;

    @Before
    public void setup() {
        startingYear = new AccountYear(STARTING_YEAR, STARTING_PRINCIPAL, STARTING_BALANCE, INTEREST,
                CAPITAL_GAINS_TAX);
        AccountProjection projection = new AccountProjection(40, startingYear);
        model = new TableStructure(projection);
    }

    @Test
    public void columnClasses() {
        for (int i = 0; i < model.getColumnCount(); i++) {
            Class<?> actualColumnClass = model.getValueAt(0, i).getClass();
            Class<?> declaredColumnClass = model.getColumnClass(i);
            String message = String.format("declared Class (%s) for column #%d, was (%s)", declaredColumnClass, i,
                    actualColumnClass);
            assertTrue(message, declaredColumnClass.isAssignableFrom(actualColumnClass));
            assertFalse("declared class in column " + i + " was " + declaredColumnClass + " it cannot be Object",
                    declaredColumnClass.equals(Object.class));
        }
    }

}