package pl.refactoring.vlog02.done.tests.pricing;

import pl.refactoring.vlog02.done.tests.Pricing;
import pl.refactoring.vlog02.done.tests.fees.EntryPeriodFeeCalculator;
import pl.refactoring.vlog02.done.tests.points.FixedPointsCalculator;

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
