package finances.domain;

import javax.swing.*;

public abstract class Year implements SelfRenderable {

    public abstract Year subsequentYear();
    public abstract String toString();
    public abstract int hashCode();
    public abstract boolean equals(Object obj);

    public abstract boolean isValid();

    public static Year parse(String text) {
        try {
            int value = Integer.parseInt(text);
            if (value >= 0) return new ValidYear(value);
        } catch (NumberFormatException e) {
        }
        return new InvalidYear();
    }

}
