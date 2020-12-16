package finances.domain;

public class AccountYear {
    private Year year;
    private Euro startPrincipal = new Euro(0);
    private Euro startProfit = new Euro(0);
    private Euro principalWithdrawn = new Euro(0);
    private Euro profitWithdrawn = new Euro(0);
    private Euro deposit = new Euro(0);
    private Percentage interest;
    private Percentage capitalGains;


    public AccountYear(Year year, Euro startPrincipal, Euro startProfit, Percentage interest, Percentage capitalGainsTax) {
        this.year = year;
        this.startPrincipal = startPrincipal;
        this.startProfit = startProfit;
        this.interest = interest;
        this.capitalGains = capitalGainsTax;
    }

    public Year year(){
        return this.year;
    }

    public Euro netTotalStart() {
        return startPrincipal.plus(startProfit);
    }

    public Euro fullTermPrincipal() {
        return startPrincipal.minus(principalWithdrawn);
    }

    public Percentage principalNetGrowth() {
        return interest.combinedRate(capitalGains.inverseRate());
    }

    public Euro fullTermProfit() {
        return startProfit.minus(profitWithdrawn);
    }

    public Percentage profitNetGrowth() {
        return interest;
    }

    public Euro balanceOfDeposits() {
        return deposit;
    }

    public Euro netProfitGenerated() {
        return principalNetGrowth().appreciate(fullTermPrincipal()).plus(profitNetGrowth().appreciate(fullTermProfit()));
    }

    public Euro netTotalEnd() {
        return principalBroughtForward().plus(profitBroughtForward());
    }

    public AccountYear newYear() {
        return new AccountYear(year.subsequentYear(), principalBroughtForward(), profitBroughtForward(), interest, capitalGains);
    }

    public void deposit(Euro amount) {
        deposit = deposit.plus(amount);
    }

    public void withdrawAmount(Euro amount) {
        deposit = deposit.minus(amount);
        if (deposit.isOverdrawn()) {
            withdrawPrincipal();
        }
    }

    private void withdrawPrincipal() {
        principalWithdrawn = principalWithdrawn.minus(deposit);
        deposit = new Euro(0);
        if (fullTermPrincipal().isOverdrawn()) {
            withdrawProfit();
        }
    }

    private void withdrawProfit() {
        profitWithdrawn = profitWithdrawn.minus(fullTermPrincipal());
        principalWithdrawn = startPrincipal;
        if (fullTermProfit().isOverdrawn()) {
            overdrawAccount();
        }
    }

    private void overdrawAccount() {
        deposit = fullTermProfit();
        profitWithdrawn = startProfit;
    }

    private Euro principalBroughtForward() {
        return fullTermPrincipal().plus(deposit);
    }

    private Euro profitBroughtForward() {
        return fullTermProfit().plus(netProfitGenerated());
    }
}
