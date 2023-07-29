package pl.refactoring.done.tests;

import pl.refactoring.done.tests.fees.EntryPeriodFeeCalculator;

/**
 * Sources provided under freeware licence
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
