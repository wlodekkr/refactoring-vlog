package pl.refactoring.vlog02.done.pricing;

import pl.refactoring.vlog02.done.Pricing;
import pl.refactoring.vlog02.done.fees.EntryPeriodFeeCalculator;
import pl.refactoring.vlog02.done.points.FixedPointsCalculator;

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
