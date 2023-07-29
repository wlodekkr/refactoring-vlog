package pl.refactoring.done.tests.pricing;

import pl.refactoring.done.tests.Pricing;
import pl.refactoring.done.tests.fees.EntryPeriodFeeCalculator;
import pl.refactoring.done.tests.points.FixedPointsCalculator;

/**
 * Sources provided under freeware licence
 * Wlodek Krakowski - www.refactoring.pl
 */
public class SwimmingPoolPricing extends Pricing {

    public SwimmingPoolPricing() {
        super(new EntryPeriodFeeCalculator(3.0, 1, 1.5),
                new FixedPointsCalculator());
    }

}
