package finances.domain;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProjectionTest {

    @Test
    public void yearRange() {
        Projection projection = new Projection(40, new AccountYear(2020, new Euro(10000), new Euro(3000), new Percentage(10), new Percentage(25)));
        assertEquals(2060, projection.lastYear());
        AccountYear year = projection.projectionYear(0);
        assertEquals(new Euro(10000), projection.projectionYear(0).fullTermPrincipal());
        assertEquals(new Euro(3000), projection.projectionYear(0).fullTermProfit());
        assertEquals("Year 1 Profit", new Euro(4050), projection.projectionYear(1).fullTermProfit());
    }

    @Test
    public void PrecisionOfCumulativeOperationsTest() {
        Projection projection = new Projection(40, new AccountYear(2020, new Euro(7000), new Euro(2250), new Percentage(10), new Percentage(25)));
        assertEquals( 2060, projection.projectionYear(40).year());
        assertEquals("ending balance 2060", new Euro(375139), projection.projectionYear(40).netTotalEnd());
    }
}