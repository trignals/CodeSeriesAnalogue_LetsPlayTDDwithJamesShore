package finances.ui;

import finances.domain.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProjectionModelTest {

    private ProjectionModel model;

    @Before
    public void setup() {
        model = new ProjectionModel();
    }

    @Test
    public void shouldStartWithDefaultStockMarket() {
        AccountProjection projection = model.tabulatedModel().accountProjection();

        AccountYear startingYear = projection.year(0);
        assertEquals(ProjectionModel.DEFAULT_STARTING_YEAR, startingYear.year());
        assertEquals(ProjectionModel.DEFAULT_INTEREST, startingYear.profitNetGrowth());

        assertEquals(41, projection.duration());
    }

    @Test
    public void shouldOnlyHaveOneInstanceOfTabulatedModel() {
        assertTrue("should be same instance", model.tabulatedModel() == model.tabulatedModel());
    }

    @Test
    public void changingStartingYearShouldChangeProjectionModel() {
        model.setStartingYear(new ValidYear(2021));
        assertEquals(new ValidYear(2021), model.tabulatedModel().startingYear());

    }

}