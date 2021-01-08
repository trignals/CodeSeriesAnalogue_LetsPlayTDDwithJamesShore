package finances.ui;

import finances.domain.ValidYear;
import finances.domain.Year;
import org.junit.Test;

import javax.swing.*;

import static org.junit.Assert.*;

public class WindowTest {
    private Data model = new Data();
    private Window frame = new Window(model);

    @Test
    public void startingYearShouldBeInitialisedToModelsValue() {
        assertEquals("starting balance field text", model.getStartingYear(), Year.parse(frame.startingYearField().getText()));
    }

    @Test
    public void startingYearFieldShouldUpdateProjectionModelThroughAction() {
        class MockApplication extends Data {
            public Year setStartingYearCalledWith;

            @Override
            public void setStartingYear(Year startingYear) {
                setStartingYearCalledWith = startingYear;
            }
        }
        MockApplication mockModel = new MockApplication();
        frame = new Window(mockModel);

        JTextField field = frame.startingYearField();
        field.setText("2035");
        assertEquals("ProjectionModel should be updated", new ValidYear(2035), mockModel.setStartingYearCalledWith);
    }
}