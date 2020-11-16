public class AccountYear {
    private Euro startPrincipal = new Euro(0);
    private Euro startProfit = new Euro(0);
    private Euro principalWithdrawn = new Euro(0);
    private Euro profitWithdrawn = new Euro(0);
    private Euro deposit = new Euro(0);
    private Rate interest = new Rate(0);
    private Rate capitalGains = new Rate(0);


    public AccountYear() {
    }

    public AccountYear(Euro startPrincipal) {
        this.startPrincipal = startPrincipal;
    }

    public AccountYear(Euro startingPrincipal, Rate interest) {
        this.startPrincipal = startingPrincipal;
        this.interest = interest;
    }

    public AccountYear(Euro startPrincipal, Euro startProfit, Rate interest) {
        this.startPrincipal = startPrincipal;
        this.startProfit = startProfit;
        this.interest = interest;
    }

    public AccountYear(Euro startPrincipal, Euro startProfit, Rate interest, Rate capitalGainsTax) {
        this.startPrincipal = startPrincipal;
        this.startProfit = startProfit;
        this.interest = interest;
        this.capitalGains = capitalGainsTax;
    }


    public Euro startNetTotal() {
        return startPrincipal.plus(startProfit);
    }

    public Euro fullTermPrincipal() {
        return startPrincipal.minus(principalWithdrawn);
    }

    public Rate netGrowthForPrincipal() {
        return interest.combinedRate(capitalGains.inverseRate());
    }

    public Euro fullTermProfit() {
        return startProfit.minus(profitWithdrawn);
    }

    public Rate netGrowthForProfit() {
        return interest;
    }

    public Euro balanceOfDeposits() {
        return deposit;
    }

    public Euro netProfitIncrease() {
        return netGrowthForPrincipal().appreciate(fullTermPrincipal()).plus(netGrowthForProfit().appreciate(fullTermProfit()));
    }

    public Euro endNetTotal() {
        return principalBroughtForward().plus(profitBroughtForward());
    }

    public AccountYear newYear() {
        return new AccountYear(principalBroughtForward(), profitBroughtForward(), interest, capitalGains);
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
        return fullTermProfit().plus(netProfitIncrease());
    }
}
