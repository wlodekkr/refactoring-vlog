package pl.refactoring.tutor.testsrefactoring.pricing;

import pl.refactoring.tutor.testsrefactoring.fees.EntryPeriodFeeCalculator;
import pl.refactoring.tutor.testsrefactoring.Pricing;
import pl.refactoring.tutor.testsrefactoring.points.FixedPointsCalculator;

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
