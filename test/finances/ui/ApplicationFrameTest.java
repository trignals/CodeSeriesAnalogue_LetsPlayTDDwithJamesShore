package finances.ui;

import finances.domain.ValidYear;
import finances.domain.Year;
import org.junit.Test;

import javax.swing.*;

import static org.junit.Assert.*;

public class ApplicationFrameTest {
    private ApplicationFrame frame = new ApplicationFrame(new ProjectionModel());

    @Test
    public void startingYearFieldShouldUpdateProjectionModelThroughAction() {
        class MockApplicationModel extends ProjectionModel {
            public Year setStartingYearCalledWith;

            @Override
            public void setStartingYear(Year startingYear) {
                setStartingYearCalledWith = startingYear;
            }

        }
        MockApplicationModel mockModel = new MockApplicationModel();
        frame = new ApplicationFrame(mockModel);

        JTextField field = frame.startingYearField();
        field.setText("2035");
        assertEquals("ProjectionModel should be updated", new ValidYear(2035), mockModel.setStartingYearCalledWith);
    }

}