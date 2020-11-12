public class AccountYear {
    private Euro deposit = new Euro(0);
    private Euro startBalance = new Euro(0);
    public Euro endCapitalGains = new Euro(0);
    private Interest interestRate;


    public AccountYear() {
    }

    public AccountYear(Euro startingBalance) {
        this.startBalance = startingBalance;
    }

    public AccountYear(Euro startingBalance, int interestRate) {
        this.startBalance = startingBalance;
        this.interestRate = new Interest(interestRate);
    }


    public void deposit(Euro amount) {
        deposit = deposit.plus(amount);
    }

    public Euro netBalance() {
        return startBalance.plus(deposit);
    }

    public void withdraw(Euro amount) {
        deposit = deposit.minus(amount);
    }

    public void newYear() {
        this.endCapitalGains = this.interestRate.calculateInterest(startBalance);
    }
}





























