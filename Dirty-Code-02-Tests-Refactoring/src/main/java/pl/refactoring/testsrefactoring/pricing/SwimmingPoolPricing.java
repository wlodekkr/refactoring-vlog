package pl.refactoring.testsrefactoring.pricing;

import pl.refactoring.testsrefactoring.Pricing;
import pl.refactoring.testsrefactoring.fees.EntryPeriodFeeCalculator;
import pl.refactoring.testsrefactoring.points.FixedPointsCalculator;

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
