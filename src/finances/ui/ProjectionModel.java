package finances.ui;

import finances.domain.*;

public class ProjectionModel {
    public static Year DEFAULT_STARTING_YEAR = new ValidYear(2020);
    public static int DEFAULT_DURATION = 40;
    public static Euro DEFAULT_PRINCIPAL = new Euro(10000);
    public static Euro DEFAULT_GAINS = new Euro(3000);
    public static Percentage DEFAULT_INTEREST = new Percentage(10);
    public Percentage DEFAULT_CAPITAL_GAINS_TAX = new Percentage(25);

    private Year startingYear = DEFAULT_STARTING_YEAR;
    private int duration = DEFAULT_DURATION;
    private Euro principal = DEFAULT_PRINCIPAL;
    private Euro gains = DEFAULT_GAINS;
    private Percentage interest = DEFAULT_INTEREST;
    private Percentage capitalGainsTax = DEFAULT_CAPITAL_GAINS_TAX;

    private TabulatedModel tabulatedModel = new TabulatedModel(accountProjection());

    public TabulatedModel tabulatedModel() {
        return tabulatedModel;
    }

    public AccountProjection accountProjection() {
        AccountYear firstYear = new AccountYear(
                startingYear, principal, gains, interest, capitalGainsTax);
        return new AccountProjection(duration, firstYear);
    }

    public void setStartingYear(Year startingYear) {
        this.startingYear = startingYear;
        tabulatedModel.setProjection(accountProjection());
    }

}
