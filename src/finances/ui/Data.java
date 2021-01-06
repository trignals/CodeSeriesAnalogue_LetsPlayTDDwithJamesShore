package finances.ui;

import finances.domain.*;

import java.util.Calendar;

public class Data {
    public Year DEFAULT_STARTING_YEAR = new ValidYear(Calendar.getInstance().get(Calendar.YEAR));
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

    private TableStructure tableStructure = new TableStructure(accountProjection());

    public TableStructure tabulatedModel() {
        return tableStructure;
    }

    public AccountProjection accountProjection() {
        AccountYear firstYear = new AccountYear(
                startingYear, principal, gains, interest, capitalGainsTax);
        return new AccountProjection(duration, firstYear);
    }

    public void setStartingYear(Year startingYear) {
        this.startingYear = startingYear;
        tableStructure.setProjection(accountProjection());
    }

    public Year startingYear() {
        return this.startingYear;
    }
}
