package pl.refactoring.vlog02.done.pricing;

import pl.refactoring.vlog02.done.Pricing;
import pl.refactoring.vlog02.done.fees.EntryPeriodFeeCalculator;
import pl.refactoring.vlog02.done.points.FixedPointsCalculator;

/**
 * Sources provided under artistic license
 * Wlodek Krakowski - www.refactoring.pl
 */
public class SwimmingPoolPricing extends Pricing {

    public SwimmingPoolPricing() {
        super(new EntryPeriodFeeCalculator(3.0, 1, 1.5),
                new FixedPointsCalculator());
    }

}
