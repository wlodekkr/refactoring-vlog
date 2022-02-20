package pl.refactoring.tutor.testsrefactoring.pricing;

import pl.refactoring.tutor.testsrefactoring.fees.EntryPeriodFeeCalculator;
import pl.refactoring.tutor.testsrefactoring.Pricing;
import pl.refactoring.tutor.testsrefactoring.points.FixedPointsCalculator;

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
