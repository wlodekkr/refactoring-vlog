package pl.refactoring.vlog02.done.tests.pricing;

import pl.refactoring.vlog02.done.tests.Pricing;
import pl.refactoring.vlog02.done.tests.fees.EntryPeriodFeeCalculator;
import pl.refactoring.vlog02.done.tests.points.FixedPointsCalculator;

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
