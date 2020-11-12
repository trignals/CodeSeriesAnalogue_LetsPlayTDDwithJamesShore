public class Interest {
    private double Rate = 0.0;

    public Interest(int interestRate) {
        this.Rate = (double)(interestRate);
    }

    public Euro calculateInterest(Euro amount) {
        return amount.percentage(this.Rate);
    }

    @Override
    public String toString() {
        return Rate + "%";
    }

}
