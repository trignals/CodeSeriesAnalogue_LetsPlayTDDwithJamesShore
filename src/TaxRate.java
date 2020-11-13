public class TaxRate {
    private double Rate;

    public TaxRate(int capitalGains) {
        this.Rate = capitalGains;
    }

    public Euro dueForNet(Euro amount) {
        return amount.percentage(this.Rate / (1 - (this.Rate / 100)));
    }

    public Object dueFromGross(Euro amount) {
        return amount.percentage(this.Rate);
    }

    @Override
    public String toString() {
        return Rate + "%";
    }

}
