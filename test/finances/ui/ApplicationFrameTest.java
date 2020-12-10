package finances.ui;

import org.junit.Test;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import static org.junit.Assert.*;

public class ApplicationFrameTest {
    private ApplicationFrame frame = new ApplicationFrame(new ProjectionModel());

    @Test
    public void startingYearFieldShouldUpdateProjectionModelThroughAction() {
        class MockApplicationModel extends ProjectionModel {
            public int setStartingYearCalledWith;

            @Override
            public void setStartingYear(int startingYear) {
                setStartingYearCalledWith = startingYear;
            }

        }
        MockApplicationModel mockModel = new MockApplicationModel();
        frame = new ApplicationFrame(mockModel);

        JTextField field = frame.startingYearField();
        field.setText("2035");
        assertEquals("ProjectionModel should be updated", 2035, mockModel.setStartingYearCalledWith);
    }

}