package finances.ui;

import finances.domain.ValidYear;
import finances.domain.Year;

import javax.swing.*;

public class YearTextField extends JTextField {
    private static final long serialVersionID = 1L;


    public YearTextField(int year) {
        this.setText(Integer.toString(year));
    }

    public Year getYear() {
        String text = getText();
        int value = 0;
        try {
            value = Integer.parseInt(text);
        } catch(NumberFormatException e) {
        }
        if (value > 0) return new ValidYear(value);
        return new ValidYear(0);
    }
}
