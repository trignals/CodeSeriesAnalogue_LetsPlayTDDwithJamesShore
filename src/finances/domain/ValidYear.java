package finances.domain;

public class ValidYear extends Year{
    private int year;

    public ValidYear(int year) {
        this.year = year;
    }

    public int is() {
        return year;
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
        ValidYear that = (ValidYear)obj;
        return this.year == that.year;
    }

}
