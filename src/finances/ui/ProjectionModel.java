package finances.ui;

import finances.domain.*;

public class ProjectionModel {
    public static final int DEFAULT_STARTING_YEAR = 2020;
    public static final int DEFAULT_DURATION = 40;
    public static final Euro DEFAULT_PRINCIPAL = new Euro(10000);
    public static final Euro DEFAULT_GAINS = new Euro(3000);
    public static final Percentage DEFAULT_INTEREST = new Percentage(10);
    public static final Percentage DEFAULT_CAPITAL_GAINS_TAX = new Percentage(25);

    private TabulatedModel tabulatedModel = new TabulatedModel(accountProjection());

    public TabulatedModel tabulatedModel() {
        return tabulatedModel;
    }

    private AccountProjection accountProjection() {
        AccountYear firstYear = new AccountYear(
                DEFAULT_STARTING_YEAR, DEFAULT_PRINCIPAL, DEFAULT_GAINS,
                DEFAULT_INTEREST, DEFAULT_CAPITAL_GAINS_TAX);
        return new AccountProjection(DEFAULT_DURATION, firstYear);
    }

    //TODO spike code re-do
//    public void setStartYear(int startYear) {
//        AccountYear updatedYear = new AccountYear(
//                startYear, new Euro(5), new Euro(5),
//                new Percentage(5), new Percentage(5));
//        AccountProjection updatedProjection = new AccountProjection(5, updatedYear);
//        projectionTableModel.setProjection(updatedProjection);
//    }

}
