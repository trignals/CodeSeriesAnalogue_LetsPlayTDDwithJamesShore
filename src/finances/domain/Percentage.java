package finances.domain;

import finances.util.Require;

public class Percentage {
    private double percent;

    public Percentage(double percent) {
        Require.that(percent > 0, "Rate Must be greater than 0; was " + percent);
        this.percent = percent;
    }

    public Percentage combinedRate(Percentage otherPercentage) {
        return new Percentage(this.percent * otherPercentage.percent / 100 );
    }

    public Percentage inverseRate() {
        return new Percentage(100 - this.percent);
    }

    public Euro appreciate(Euro amount) {
        return amount.percent(this.percent);
    }

    @Override
    public String toString() {
        return percent + "%";
    }

}
