public class Interest {
    private double Rate;

    public Interest(int interestRate) {
        this.Rate = interestRate;
    }

    public Euro calculateInterest(Euro amount) {
        return amount.percentage(this.Rate);
    }

    @Override
    public String toString() {
        return Rate + "%";
    }

}
