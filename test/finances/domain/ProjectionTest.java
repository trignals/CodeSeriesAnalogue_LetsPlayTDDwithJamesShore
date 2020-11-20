package finances.domain;

import finances.domain.*;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProjectionTest {

    @Test
    public void yearRange() {
        Projection projection = new Projection(40, new AccountYear(2020, new Euro(10000), new Euro(3000), new Rate(10), new Rate(25)));
        assertEquals(2060, projection.lastYear());
        AccountYear year = projection.projectionYear(0);
        assertEquals(new Euro(10000), projection.projectionYear(0).fullTermPrincipal());
        assertEquals(new Euro(3000), projection.projectionYear(0).fullTermProfit());
        assertEquals("Year 1 Profit", new Euro(4050), projection.projectionYear(1).fullTermProfit());
    }
}