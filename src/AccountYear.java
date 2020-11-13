public class AccountYear {
    private TaxRate netGains;
    private Euro deposit = new Euro(0);
    private Euro startPrincipal = new Euro(0);
    public Euro startNetGains = new Euro(0);
    public Euro endNetGains = new Euro(0);
    private Interest interestRate;
    private TaxRate capitalGains;


    public AccountYear() {
    }

    public AccountYear(Euro startingPrincipal) {
        this.startPrincipal = startingPrincipal;
    }

    public AccountYear(Euro startingPrincipal, Interest interestRate) {
        this.startPrincipal = startingPrincipal;
        this.interestRate = interestRate;
    }

    public AccountYear(Euro startingPrincipal, Euro startingCapitalGains, Interest interestRate) {
        this.startPrincipal = startingPrincipal;
        this.startNetGains = startingCapitalGains;
        this.interestRate = interestRate;
    }

    public AccountYear(Euro startingPrincipal, Euro startingNetGains, Interest interestRate, TaxRate netGains) {
        this.startPrincipal = startingPrincipal;
        this.startNetGains = startingNetGains;
        this.interestRate = interestRate;
        this.capitalGains = netGains;
    }


    public void deposit(Euro amount) {
        deposit = deposit.plus(amount);
    }

    public Euro testBalance() {
        return startNetGains.plus(startPrincipal.plus(deposit));
    }

    public void withdraw(Euro amount) {
        deposit = deposit.minus(amount);
    }

    public void newYear() {
        this.endNetGains = startNetGains.plus(this.interestRate.calculateInterest(startPrincipal.plus(startNetGains)));
    }

    public Euro grossProfit() {
        return startNetGains.plus(capitalGains.dueForNet(startNetGains));
    }

}
