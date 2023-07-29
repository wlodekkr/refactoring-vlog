package pl.refactoring.done.tests.pricing;

import pl.refactoring.done.tests.Pricing;
import pl.refactoring.done.tests.fees.EntryPeriodFeeCalculator;
import pl.refactoring.done.tests.points.FixedPointsCalculator;

/**
 * Sources provided under freeware licence
 * Wlodek Krakowski - www.refactoring.pl
 */
public class GymPricing extends Pricing {

    public GymPricing() {
        super(new EntryPeriodFeeCalculator(4.0, 2, 0.50),
                new FixedPointsCalculator());
    }

}
