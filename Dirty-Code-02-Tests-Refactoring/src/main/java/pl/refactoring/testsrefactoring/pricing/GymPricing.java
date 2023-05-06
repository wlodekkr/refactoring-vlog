package pl.refactoring.testsrefactoring.pricing;

import pl.refactoring.testsrefactoring.Pricing;
import pl.refactoring.testsrefactoring.fees.EntryPeriodFeeCalculator;
import pl.refactoring.testsrefactoring.points.FixedPointsCalculator;

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
