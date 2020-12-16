package finances.ui;

import finances.domain.InvalidYear;
import finances.domain.ValidYear;
import finances.domain.Year;

import javax.swing.*;

public class YearTextField extends JTextField {
    private static final long serialVersionID = 1L;


    public YearTextField(int year) {
        this.setText(Integer.toString(year));
    }

    public Year getYear() {
        return Year.parse(getText());
    }
}
