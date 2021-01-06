package finances.domain;

import finances.ui.RenderSubject;
import finances.util.Resource;

import java.awt.*;
import java.util.Calendar;

public class ValidYear extends Year {
    private int year;
    private int currentYear = Calendar.getInstance().get(Calendar.YEAR);

    public ValidYear(int year) {
        this.year = year;
    }

    public Year subsequentYear() {
        if (this.year >= currentYear + super.MAX_TIME_TO_INVEST) return new InvalidYear();
        return new ValidYear(this.year + 1);
    }

    public void render(Resource resource, RenderSubject renderSubject) {
        renderSubject.setText(this.toString());
        renderSubject.setIcon(null);
        renderSubject.setToolTipText(null);
        renderSubject.setForegroundColor(Color.BLACK);
        if (this.year < currentYear) renderSubject.setForegroundColor(Color.RED);
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
