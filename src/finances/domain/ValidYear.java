package finances.domain;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

public class ValidYear extends Year {
    private int year;

    public ValidYear(int year) {
        this.year = year;
    }

    public Year subsequentYear() {
        return new ValidYear(this.year + 1);
    }

    public void render(JLabel label) {
        label.setText(this.toString());
        label.setIcon(null);
        label.setToolTipText(null);
        label.setForeground(Color.BLACK);
        if (this.year < Calendar.getInstance().get(Calendar.YEAR)) label.setForeground(Color.RED);
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public String toString() {
        return Integer.toString(year);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        long temp = Double.doubleToLongBits(year);
        return prime + (int) (temp ^ (temp >>> (prime + 1)));
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ValidYear)) return false;
        ValidYear that = (ValidYear)obj;
        return this.year == that.year;
    }

}
