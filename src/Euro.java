import java.util.Objects;

public class Euro {
    private int value;

    public Euro(int amount) {
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
        return "€" + value;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        long temp = Double.doubleToLongBits(value);
        return prime + (int) (temp ^ (temp >>> (prime + 1)));
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Euro other = (Euro) obj;
        return Double.doubleToLongBits(value) == Double.doubleToLongBits(other.value);
    }

    public Euro percent(double rate) {
        return new Euro((int)(this.value * rate) / 100);
    }

    public boolean isOverdrawn() {
        return this.value < 0;
    }
}
