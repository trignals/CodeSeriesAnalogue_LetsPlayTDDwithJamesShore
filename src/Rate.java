public class Rate {
    private double percent;

    public Rate(double percent) {
        this.percent = percent;
    }

    public Rate combinedRate(Rate otherRate) {
        return new Rate(this.percent * otherRate.percent / 100 );
    }

    public Rate inverseRate() {
        return new Rate(100 - this.percent);
    }

    public Euro appreciate(Euro amount) {
        return amount.percent(this.percent);
    }

    @Override
    public String toString() {
        return percent + "%";
    }

}
