package pl.refactoring.vlog02.todo;

import pl.refactoring.vlog02.todo.fees.EntryPeriodFeeCalculator;

/**
 * Sources provided under artistic license
 * Wlodek Krakowski - www.refactoring.pl
 */
public abstract class Pricing {
    private final EntryPeriodFeeCalculator priceCalculator;
    private final PointsCalculator pointsCalculator;

    protected Pricing(EntryPeriodFeeCalculator priceCalculator, PointsCalculator pointsCalculator) {
        this.priceCalculator = priceCalculator;
        this.pointsCalculator = pointsCalculator;
    }

    public double countPrice(int hours) {
        return priceCalculator.calculateFee(hours);
    }

    public int countPoints(int hours) {
        return pointsCalculator.countPoints(hours);
    }
}
