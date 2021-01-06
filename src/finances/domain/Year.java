package finances.domain;

import java.util.Calendar;

public abstract class Year implements SelfRendering {

    public abstract Year subsequentYear();
    public abstract String toString();
    public abstract int hashCode();
    public abstract boolean equals(Object obj);

    public abstract boolean isValid();
    protected static final int MAX_TIME_TO_INVEST = 100;

    public static Year parse(String text) {
        try {
            int value = Integer.parseInt(text);
            int currentYear = Calendar.getInstance().get(Calendar.YEAR);
            if (value > 0 && value <= currentYear + MAX_TIME_TO_INVEST) return new ValidYear(value);
        } catch (NumberFormatException e) {
        }
        if (text.equals("") || text.equals("0")) return new ValidYear(0);
        return new InvalidYear();
    }

}
