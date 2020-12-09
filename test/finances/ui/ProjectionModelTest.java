package finances.ui;

import finances.domain.AccountProjection;
import finances.domain.AccountYear;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProjectionModelTest {

    @Test
    public void shouldStartWithDefaultStockMarket() {
        ProjectionModel model = new ProjectionModel();
        AccountProjection projection = model.tabulatedModel().getProjection();

        AccountYear startingYear = projection.year(0);
        assertEquals(ProjectionModel.DEFAULT_STARTING_YEAR, startingYear.year());
        assertEquals(ProjectionModel.DEFAULT_INTEREST, startingYear.profitNetGrowth());

        assertEquals(41, projection.duration());
    }

    @Test
    public void TableFrameShouldUseProjection() {

    }

}