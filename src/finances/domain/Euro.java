package finances.domain;

import finances.util.Require;

public class Euro {
    private double value;

    public Euro(int amount) {
        this.value = amount;
    }

    public Euro(double amount) {
        this.value = amount;
    }

    public Euro plus(Euro amount) {
        return new Euro(this.value + amount.value);
    }

    public Euro minus(Euro amount) {
        return new Euro(this.value - amount.value);
    }

    @Override
    public String toString() {
        return "€" + toNearestEuro();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        long temp = Double.doubleToLongBits(value);
        return prime + (int) (temp ^ (temp >>> (prime + 1)));
    }

    @Override
    public boolean equals(Object obj) {
        Euro that = (Euro)obj;
        return this.toNearestEuro() == that.toNearestEuro();
    }

    private long toNearestEuro() {
        return Math.round(this.value);
    }

    public Euro percent(double rate) {
        return new Euro((this.value * rate) / 100);
    }

    public boolean isOverdrawn() {
        return this.value < 0;
    }
}
